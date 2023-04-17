package br.com.dev.students.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.dev.students.model.Material;

public interface MaterialsRepository extends MongoRepository<Material, String>{
    
}
