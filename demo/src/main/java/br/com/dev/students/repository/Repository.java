package br.com.dev.students.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.dev.students.entity.Student;

public interface Repository extends MongoRepository<Student, String>{
    
}
