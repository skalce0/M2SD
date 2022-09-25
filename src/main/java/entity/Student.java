package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="students")
@Data
public class Student {
    @Id
    @GeneratedValue

    private Integer Id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "age")
    private Integer age;
    @Column(name = "email")
    private String email;

    public Student(String firstname, String lastname, Integer age, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
    }
}