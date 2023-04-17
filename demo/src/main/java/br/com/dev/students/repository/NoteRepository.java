package br.com.dev.students.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.dev.students.model.Note;

public interface NoteRepository extends MongoRepository<Note, String>{
    
}
