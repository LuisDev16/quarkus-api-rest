package my.group.dto;

import my.group.entity.Status;

import java.time.LocalDate;

public record PersonResposeDto(
        Long id,
        String name,
        LocalDate birth,
        Status status,
        Integer age,
        String email
) {
}
