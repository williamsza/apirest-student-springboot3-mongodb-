package br.com.dev.students.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.students.model.Student;
import br.com.dev.students.repository.MaterialsRepository;
import br.com.dev.students.repository.NoteRepository;
import br.com.dev.students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Service
public class StudentSevice {
    private final StudentRepository studentRepository;

    // public StudentSevice(StudentRepository studentRepository) {
    //     this.studentRepository = studentRepository;
    // }
    
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
    
    public Student insertStudent(Student student) {
        return studentRepository.insert(student);
    }
    
    public Student updateStudent(String id, Student studentData) {
        Optional<Student> student = findById(id);
    
        if (student.isPresent()) {
            Student existingStudent = student.get();
            existingStudent.setNome(studentData.getNome());
            existingStudent.setSobrenome(studentData.getSobrenome());
            existingStudent.setCpf(studentData.getCpf());
            studentRepository.save(existingStudent);
            return existingStudent;
        }
    
        return null;
    }
    
    public void remove(String id) {
        Optional<Student> student = findById(id);
    
        student.ifPresent(value -> studentRepository.delete(value));
    }
    
    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);
    }
    
}









