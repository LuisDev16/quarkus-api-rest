package my.group.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import my.group.dto.PersonRequestDto;
import my.group.dto.PersonResposeDto;
import my.group.entity.Person;
import my.group.mapper.PersonMapper;

import java.util.List;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {

    @Override
    @Transactional
    public void createPerson(PersonRequestDto personRequestDto) {
       var person =  PersonMapper.fromDto(personRequestDto);
       person.persist();
    }

    @Override
    public PersonResposeDto getPersonById(Long id) {
        var personDb = findByIdPerson(id);
        return PersonMapper.fromEntity(personDb);
    }

    @Override
    public List<PersonResposeDto> getPeople() {
      return PersonMapper.fromDto(Person.listAll());
    }

    private void validateEmail(String email) {

    }

    @Override
    @Transactional
    public void deletePerson(Long id) {
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

    private Person findByIdPerson(Long id) {
        return Person.<Person>findByIdOptional(id)
                .orElseThrow(()-> new NotFoundException("Person with id: %d not exists".formatted(id)));
    }
}
