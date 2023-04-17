package br.com.dev.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.students.model.Note;
import br.com.dev.students.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Service

public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(String id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public Note update(String id, Note newNoteData) {
        Note existingNote = noteRepository.findById(id).orElse(null);
        if (existingNote == null) {
            return null;
        }
        existingNote.setNoteId(newNoteData.getNoteId());
        existingNote.setValor(newNoteData.getValor());
        return noteRepository.save(existingNote);
    }

    public void deleteById(String id) {
        noteRepository.deleteById(id);
    }

    public Note addNote(Note note) {
        return null;
    }

    public Note updateNote(String id, Note note) {
        return null;
    }

    public boolean deleteNoteById(String id) {
        return false;
    }
}
