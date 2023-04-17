package br.com.dev.students.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.dev.students.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{

   // Student findByRegistration(String registration);

   //public Student findByRegistration(String registration);
    
}
