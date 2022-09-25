package api;


import entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import repository.StudentEntityRepository;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor

public class StudentApi {

    private final StudentEntityRepository studentEntityRepository;

    //get all students from database

    @GetMapping("students")
    public List<Student> getAll(){
        return studentEntityRepository.getAll();
    }
    // get a student by email

    @GetMapping("students/{email}")
    public Optional<Student> findByEmail(@PathVariable String email){
        Optional<Student> student = StudentEntityRepository.findByEmail(email);
        return student;
    }

    //get all students by first name

    @GetMapping("students")
    public Optional<Student> findByFirstname(@PathVariable String firstname){
        Optional<Student> student = studentEntityRepository.getByFirstname(firstname);
        return student;
    }

    @GetMapping("students")
    public Optional<Student> findByAgeAfter(Integer age){
        Optional<Student> student = studentEntityRepository.findByAgeAfter(20);
        return student;
    }

    //save a new student
    @PostMapping("students")
    public Student save (@RequestBody Student s){
        return studentEntityRepository.save(s);
    }

    // modify the email of a student (by passing his id and the new email)
    @PutMapping("students")
    public Student update(@RequestParam Integer id, @RequestParam String email){
        Optional<Student> student = StudentEntityRepository.findById(id);
        student.ifPresent(value->value.setEmail(email));
        return studentEntityRepository.save(student.orElse( null));
    }

    // modify the last name of a student (by passing his email and the new last name)
    @PutMapping("students")
    public Student update(@RequestParam String email, @RequestParam String lastname){
        Optional<Student> student = StudentEntityRepository.findByEmail(email);
        student.ifPresent(value->value.setLastname(lastname));
        return studentEntityRepository.save(student.orElse( null));
    }
/*
    @PutMapping("students")
    public Student update(@RequestBody Student s, @RequestParam String email){
        Optional<Student> student = StudentEntityRepository.findById(s.getId());
        student.ifPresent(value->value.setEmail(email));
        return studentEntityRepository.save(student.orElse( null));
    }
*/
    // Modify the age of all student (increment by 1)





    // Delete a student (given @RequestBody Student student)
    @DeleteMapping("student")
    public void delete(@RequestBody Student student){
        studentEntityRepository.delete(student.orElse(null));
    }
}


