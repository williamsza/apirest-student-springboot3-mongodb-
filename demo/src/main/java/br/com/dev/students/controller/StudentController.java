package br.com.dev.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.students.model.Student;
import br.com.dev.students.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }
    
    @PostMapping("")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
    
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }
    
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }
    
    @GetMapping("/cpf/{cpf}")
    public List<Student> getByCpf(@PathVariable String cpf) {
        return studentService.getByCpf(cpf);
    }
}


// @RestController
// @RequestMapping("/api/students")
// public class StudentController {


//     @Autowired
//     private StudentSevice studentService;

//     @GetMapping
//     public ResponseEntity<List<Student>> getAll() {
//         List<Student> students = studentService.getAll();
//         return ResponseEntity.ok().body(students);
//     }

//     @PostMapping
//     public ResponseEntity<Student> insertStudent(@RequestBody @Valid Student student) {
//         studentService.insertStudent(student);
//         return ResponseEntity.created(null).body(student);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Student> updateStudent(@RequestBody Student studentData, @PathVariable String id) {
//         Optional<Student> student = studentService.findById(id);

//         if (student.isEmpty()) {
//             return ResponseEntity.notFound().build();
//         }

//         Student updatedStudent = studentService.updateStudent(id, studentData);
//         return ResponseEntity.ok().body(updatedStudent);
//     }

//     @PatchMapping("/{id}")
//     public ResponseEntity<Student> updateStudentCpf(@RequestParam("cpf") String cpf, @PathVariable String id) {
//         Optional<Student> student = studentService.findById(id);

//         if (student.isEmpty()) {
//             return ResponseEntity.notFound().build();
//         }

//         Student studentData = student.get();
//         studentData.setCpf(cpf);
//         Student updatedStudent = studentService.updateStudent(id, studentData);

//         return ResponseEntity.ok().body(updatedStudent);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deletar(@PathVariable String id) {
//         Optional<Student> student = studentService.findById(id);

//         if (student.isEmpty()) {
//             return ResponseEntity.notFound().build();
//         }

//         studentService.remove(id);
//         return ResponseEntity.noContent().build();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Student> getStudentById(@PathVariable String id) {
//         Optional<Student> student = studentService.findById(id);

//         if (student.isEmpty()) {
//             return ResponseEntity.notFound().build();
//         }

//         return ResponseEntity.ok().body(student.get());
//     }
// }
