package br.com.dev.students.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.students.repository.Repository;
import br.com.dev.students.studentsnodels.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Service
public class StudentSevice {

    @Autowired
    private Repository studentRepository;

    
    public List<Student> getAll() {
        return studentRepository.findAll();

    }

    
    public Student insertStudent(Student student) {
        studentRepository.insert(student);
        return student;

    }

    
    public Student updateStudent(String id, Student studentData) {
        Optional<Student> student = findById(id);
        if (student.isPresent()) {
            Student newStudent = student.get();

            newStudent.setNome(studentData.getNome());
            newStudent.setSobrenome(studentData.getSobrenome());
            newStudent.setCpf(studentData.getCpf());
             newStudent.setNoteId(studentData.getNoteId());
             newStudent.setMaterialId(studentData.getMaterialId());

            studentRepository.save(newStudent);

            return newStudent;
        }
        return null;

    }

    

    public void remuve(String id) {
        Optional<Student> student = findById(id);
        student.ifPresent(value -> studentRepository.delete(student.get()));

    }

    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);

    }

}
