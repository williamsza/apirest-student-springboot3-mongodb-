package br.com.dev.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.dev.students.entity.Student;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final List<Student> studentList = new ArrayList<>();

    @GetMapping
    public List<Student> getAll() {
        Student student = new Student();
        return studentList;

    }

    @GetMapping("/{registration}")
    public Student searchStudentbyRegistration(@PathVariable int registration) {
        for (Student student : studentList) {
            if (student.getRegistration() == registration) {
                return student;

            }

        }
        // return studentList.get(id);
        return null;

    }

    @PostMapping
    public void insertStudent(@RequestBody Student Student) {
        studentList.add(Student);

    }

    @PutMapping("/{registration}")
    public void updateStudent(@RequestBody Student studentData, @PathVariable int registration) {
        for (Student student : studentList) {
            if (student.getRegistration() == registration) {
                student.setNome(studentData.getNome());
                student.setCpf(studentData.getCpf());
                student.setRegistration(studentData.getRegistration());
                student.setSobrenome(studentData.getSobrenome());
                

            }

        }

    }

}
