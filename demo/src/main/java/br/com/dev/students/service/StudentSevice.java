package br.com.dev.students.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.students.entity.Student;
import br.com.dev.students.repository.Repository;
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

            newStudent.setNome(newStudent.getNome());
            newStudent.setSobrenome(newStudent.getSobrenome());
            newStudent.setCpf(newStudent.getCpf());

           // BeanUtils.copyProperties(studentData, newStudent);
            studentRepository.save(newStudent);

            return newStudent;
        }
        return null;

    }

    public void remuve(String id) {
        Optional<Student> student = findById(id);
        student.ifPresent(value -> studentRepository.delete(student.get()));

    }

    // OK
    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);

    }

}
