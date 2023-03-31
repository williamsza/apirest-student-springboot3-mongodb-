package br.com.dev.students.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.students.entity.Student;
import br.com.dev.students.service.StudentSevice;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired

    private StudentSevice studentService;

    public StudentSevice getStudentService() {
        return studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();

    }

    @PostMapping
    public ResponseEntity<Student> insertStudent(@RequestBody @Valid Student student) {
        studentService.insertStudent(student);
        return ResponseEntity.created(null).body(student);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student studentData, @PathVariable String id) {
        Optional<Student> student = studentService.findById(id);

        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Student responseStudent = studentService.updateStudent(id, studentData);

       // studentService.updateStudent(id, studentData);
        return ResponseEntity.ok().body(studentData);

    }

    // ok
    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateStudentCpf(@RequestParam("cpf") String cpf,
            @PathVariable String id) {

        Optional<Student> student = studentService.findById(id);

        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Student studentData = student.get();

        studentData.setCpf(cpf);

        studentService.updateStudent(id, studentData);
        return ResponseEntity.ok().body(studentData);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deletar(@PathVariable String id) {
        Optional<Student> student = studentService.findById(id);

        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        studentService.remuve(id);
        return ResponseEntity.ok().body(null);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {

        Optional<Student> student = studentService.findById(id);

        if (student.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(student.get());
    }

}
