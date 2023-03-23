package br.com.dev.students.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.dev.students.entity.Student;
import br.com.dev.students.repository.Repository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// @RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service
public class StudentSevice {
    //private final List<Student> studentList = new ArrayList<>();

    @Autowired
    private Repository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();

    }

    public Student insertStudent(Student student) {
        studentRepository.insert(student);
        return student;

    }

    public Student updateStudent(String registration, Student studentData) {
        Student student = selectedStudentForRegistration(registration);
        if (student != null) {
            BeanUtils.copyProperties(studentData, student);
            studentRepository.save(student);

        }

        return student;

    }

    public void remuveStudent(String registration) {
        Student student = selectedStudentForRegistration(registration);
        if (student != null) {
            studentRepository.delete(student);

        }

    }

    public Student selectedStudentForRegistration(String registration) {
        final Student student = studentRepository.findByRegistration(registration);

        return student;
    }

    // public void save(Student student) {
    // studentRepository.save(student);
    // }

    // public void updateStudent(Student student) {
    // studentRepository.save(student);
    // }

    // public void deleteById(String student) {
    // studentRepository.deleteById(student);
    // }

}
