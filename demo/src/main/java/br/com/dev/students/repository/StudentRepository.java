package br.com.dev.students.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.dev.students.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{

    List<Student> findByCpf(String cpf);

   // Student findByRegistration(String registration);

   //public Student findByRegistration(String registration);
    
}
