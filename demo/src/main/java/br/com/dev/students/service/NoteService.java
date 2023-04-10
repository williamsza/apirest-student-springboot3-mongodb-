// package br.com.dev.students.service;

// import java.util.List;

// import javax.lang.model.element.Name;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// import br.com.dev.students.repository.Repository;
// import br.com.dev.students.studentsdocuments.Note;
// import br.com.dev.students.studentsdocuments.Student;
// import jakarta.validation.Valid;
// @Service
// public class NoteService {

//     @Autowired
//     private static Repository studentRepository;

//     public List<Note> getStudentsByNote(String noteId) {
//         return studentRepository.findByNote(noteId);
//     }

//     @GetMapping("/nota/cadastrar/{id}")
// 	public String cadastrar(@PathVariable String id, Note note){
// 		List<Note> nete = studentRepository.findByNote(id);
		
// 		return "nota/cadastrar";
// 	}

//     public Note findNoteById(String id) {
//         return null;
//     }

//     public List<Note> findAll() {
//         return null;
//     }

//     public Note create(Note note) {
//         return null;
//     }

//     public Note update(String id, Note note) {
//         return null;
//     }

//     public void delete(String note) {
//     }

// }
