package my.group.service;

import java.util.List;

import my.group.resource.PersonRequestDto;
import my.group.resource.PersonResponseDto;

/**
 * Service interface for Person entity operations.
 * Defines CRUD methods for Person management.
 */
public interface PersonService {

    Object getPersonById(Long id);

    void createPerson(PersonRequestDto personDto);

    void deletePerson(Long id);

    List<PersonResponseDto> getPeople();

    void updatePerson(Long id, PersonRequestDto dto);

}
