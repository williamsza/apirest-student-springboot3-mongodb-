package br.com.dev.students.service;

import org.springframework.stereotype.Service;

import br.com.dev.students.entity.Student;
import br.com.dev.students.repository.Repository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentSevice {
private final Repository repository;

    public void save(Student student) {
        repository.save(student);
    }
    
}
