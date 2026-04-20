package my.group.mapper;

import my.group.dto.PersonRequestDto;
import my.group.dto.PersonResposeDto;
import my.group.entity.Person;

import java.util.List;

public class PersonMapper {

    public static Person fromDto(PersonRequestDto dto){
        Person person = new Person();
        person.name=dto.name();
        person.email=dto.email();
        person.age=dto.age();
        person.birth=dto.birth();
        person.status=dto.status();
        return person;
    }
    public static PersonResposeDto fromEntity(Person person){
        return  new PersonResposeDto(
                person.id,
                person.name,
                person.birth,
                person.status,
                person.age,
                person.email
        );

    }

    public static List<PersonResposeDto> fromDto(List<Person> entities){
        return entities.stream()
                .map(PersonMapper::fromEntity)
                .toList();
    }


}
