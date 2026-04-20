package my.group.dto;

import my.group.entity.Status;

import java.time.LocalDate;


public record PersonRequestDto(
        String name,
        LocalDate birth,
        Status status,
        Integer age,
        String email
) {
    public String name() {
        return name;
    }

    public LocalDate birth() {
        return birth;
    }

    public Status status() {
        return status;
    }

    public Integer age() {
        return age;
    }

    public String email() {
        return email;
    }
}
