package my.group.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDate;

/*Entity created using
*Actived Record Pattern
* */
@Entity
public class Person extends PanacheEntity {
    public String name;
    public LocalDate birth;
    public Status status;
    public Integer age;
    public String email;


    public Person() {
    }

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
