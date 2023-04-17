package br.com.dev.students.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.dev.students.model.Materials;

public interface MaterialsRepository extends MongoRepository<Materials, String>{
    
}
