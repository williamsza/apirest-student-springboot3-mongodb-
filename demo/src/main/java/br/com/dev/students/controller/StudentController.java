package br.com.dev.students.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.dev.students.entity.Student;
import br.com.dev.students.service.StudentSevice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private final StudentSevice studentService;

    public StudentController(StudentSevice studentService) {
        this.studentService = studentService;
    }

    public StudentSevice getStudentService() {
        return studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();

    }

    @PostMapping
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
        studentService.insertStudent(student);
        return ResponseEntity.created(null).body(student);

    }

    @PutMapping("/{registration}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student studentData, @PathVariable String registration) {
        Student student = studentService.updateStudent(registration, studentData);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        studentService.updateStudent(registration, studentData);
        return ResponseEntity.ok().body(student);

    }

    @PatchMapping("/{registration}")
    public ResponseEntity<Student> updateStudentCpf(@RequestParam("cpf") String cpf,
            @PathVariable String registration) {

        Student student = studentService.selectedStudentForRegistration(registration);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        student.setCpf(cpf);
        studentService.updateStudent(registration, student);
        return ResponseEntity.ok().body(student);

    }

    @DeleteMapping("/{registration}")
    public ResponseEntity<Student> deletar(@PathVariable String registration) {
        Student student = studentService.selectedStudentForRegistration(registration);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.remuveStudent(registration);
        return ResponseEntity.ok().body(null);

    }
    // Remover
    // @PostMapping("/save")
    // public Student save(@RequestBody Student student) {
    // studentService.save(student);
    // return student;
    // }

}
