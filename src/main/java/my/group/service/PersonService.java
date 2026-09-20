package my.group.service;

import java.util.List;

import my.group.resource.PersonRequestDto;
import my.group.resource.PersonResponseDto;

/**
 * Service interface for Person entity operations.
 * Defines CRUD methods for Person management.
 */
public interface PersonService {

    /**
     * Finds and maps the person with the supplied identifier.
     *
     * @param id the persistent person identifier
     * @return the mapped person response
     * @throws jakarta.ws.rs.NotFoundException if no person has the identifier
     */
    Object getPersonById(Long id);

    /**
     * Attempts to validate and persist a person from a creation request.
     *
     * @param personDto the creation request
     * @throws jakarta.ws.rs.BadRequestException if the email is invalid or already registered
     * @throws UnsupportedOperationException while request access or conversion is unimplemented
     */
    void createPerson(PersonRequestDto personDto);

    /**
     * Deletes the person with the supplied identifier.
     *
     * @param id the positive persistent person identifier
     * @throws jakarta.ws.rs.BadRequestException if {@code id} is {@code null} or not positive
     * @throws jakarta.ws.rs.NotFoundException if no person has the identifier
     */
    void deletePerson(Long id);

    List<PersonResponseDto> getPeople();

    /**
     * Updates the non-null age, email, and status fields for an existing person.
     *
     * @param id the persistent person identifier
     * @param dto the partial update request
     * @throws jakarta.ws.rs.NotFoundException if no person has the identifier
     */
    void updatePerson(Long id, PersonRequestDto dto);

}
