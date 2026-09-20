package my.group.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDate;

/**
 * Entity representing a Person.
 * <p>
 * Created using Active Record Pattern for Azure DB.
 * </p>
 */
@Entity
public class Person extends PanacheEntity {
    public String name;
    public LocalDate birth;
    public Status status;
    public Integer age;
    public String email;


    public Person() {
    }

    /**
     * Initializes the name, birth date, status, and age fields.
     *
     * @param email accepted but not assigned; the new person's email remains {@code null}
     */
    public Person(String name, LocalDate birth, Status status, int age, String email) {
        this.name = name;
        this.birth = birth;
        this.status = status;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", status=" + status +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
