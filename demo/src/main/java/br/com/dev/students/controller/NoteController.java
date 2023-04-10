// package br.com.dev.students.controller;

// import java.net.URI;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import br.com.dev.students.service.NoteService;
// import br.com.dev.students.studentsdocuments.Note;

// @RestController
// // @CrossOrigin
// @RequestMapping("/note")
// public class NoteController {

//     @Autowired
//     private NoteService noteService;

//     @GetMapping("/{noteId}")
//     public ResponseEntity<Note> findById(@PathVariable String id) {
//         Note note = noteService.findNoteById(id);
//         return ResponseEntity.ok(note);
//     }

//     @GetMapping
//     public ResponseEntity<List<Note>> findAll() {
//         List<Note> notes = noteService.findAll();
//         return ResponseEntity.ok(notes);
//     }

//     @PostMapping
//     public ResponseEntity<Note> create(@RequestBody Note note) {
//         Note createdNote = noteService.create(note);
//         return ResponseEntity.created(URI.create("/notes/" + createdNote.getNoteId())).body(createdNote);
//     }

//     @PutMapping("/{noteId}")
//     public ResponseEntity<Note> update(@PathVariable String id, @RequestBody Note note) {
//         Note updatedNote = noteService.update(id, note);
//         return ResponseEntity.ok(updatedNote);
//     }

//     @DeleteMapping("/{noteId}")
//     public ResponseEntity<Void> delete(@PathVariable String id) {
//         noteService.delete(id);
//         return ResponseEntity.noContent().build();

//     }
// }