package my.group.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import my.group.resource.PersonRequestDto;

import java.util.List;

/**
 * Service implementation for managing Person entities.
 * Handles CRUD operations and validation logic.
 */
@ApplicationScoped
public class PersonServiceImpl implements PersonService {

    @Override
    @Transactional
    public void createPerson(PersonRequestDto personRequestDto) {
        validateEmail(personRequestDto.email());
        var person = PersonMapper.fromDto(personRequestDto);
        person.persist();
    }

    @Override
    public PersonResponseDto getPersonById(Long id) {
        var personDb = findByIdPerson(id);
        return PersonMapper.fromEntity(personDb);
    }

    @Override
    public List<PersonResponseDto> getPeople() {
      return PersonMapper.fromDto(Person.listAll());
    }

    /**
     * Verifies that an email has the accepted {@code .com} format and is not already stored.
     *
     * @param email the address to validate
     * @return {@code true} when the address is valid and available
     * @throws BadRequestException if the address is invalid or already registered
     */
    private boolean validateEmail(String email) {
        if (email == null || !email.matches("^[a-zA-Z0-9._%+\\-]+@[a-zA-Z0-9.\\-]+\\.com$")) {
            throw new BadRequestException("Email must be a valid address ending in .com");
        }
        if (Person.count("email = ?1", email) > 0) {
            throw new BadRequestException("Email '%s' is already registered".formatted(email));
        }
        return true;
    }

    @Override
    @Transactional
    public void deletePerson(Long id) {
        if (id == null || id <= 0) {
            throw new BadRequestException("Person id must be a positive number");
        }
        var personDb = findByIdPerson(id);
        personDb.delete();
    }

    @Override
    @Transactional
    public void updatePerson(Long personId, PersonRequestDto dto) {
        var personDb = findByIdPerson(personId);

        if (dto.age() != null) personDb.age = dto.age();
        if (dto.email() != null) personDb.email = dto.email();
        if (dto.status() != null) personDb.status = dto.status();
    }

    /**
     * Finds a persisted person by identifier.
     *
     * @param id the persistent person identifier
     * @return the matching person
     * @throws NotFoundException if no person has the identifier
     */
    private Person findByIdPerson(Long id) {
        return Person.<Person>findByIdOptional(id)
                .orElseThrow(()-> new NotFoundException("Person with id: %d not exists".formatted(id)));
    }
}
