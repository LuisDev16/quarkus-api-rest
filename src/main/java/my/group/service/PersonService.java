package my.group.service;

import my.group.dto.PersonRequestDto;
import my.group.dto.PersonResposeDto;

import java.util.List;

public interface PersonService {

    void createPerson(PersonRequestDto personRequestDto);
    PersonResposeDto getPersonById(Long id);
    List<PersonResposeDto> getPeople();
    void deletePerson(Long id);
    void updatePerson(Long personId,PersonRequestDto personRequestDto);
}
