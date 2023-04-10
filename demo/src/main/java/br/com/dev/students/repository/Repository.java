package br.com.dev.students.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.dev.students.studentsnodels.Material;
import br.com.dev.students.studentsnodels.Note;
import br.com.dev.students.studentsnodels.Student;

public interface Repository extends MongoRepository<Student, String> {

   void insert(Material material);

   void save(Material newMaterial);

   Object delete(Material material);

   List<Note> findByNote(String noteId);

   List<Note> findAllNote(String noteId);

   List<Material> findBMaterial(String materialId);

   List<Material> findAllBMaterial(String materialId);

}
