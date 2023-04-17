
package br.com.dev.students.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.students.model.Material;
import br.com.dev.students.model.Note;
import br.com.dev.students.model.Student;
import br.com.dev.students.repository.MaterialsRepository;
import br.com.dev.students.repository.NoteRepository;
import br.com.dev.students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MaterialsRepository materialsRepository;

    @Autowired
    private NoteRepository noteRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        List<Material> materials = getMaterialsFromIds(student.getMaterialsIds());
        List<Note> notes = getNotesFromIds(student.getNotesIds());

        student.setMaterials(materials);
        student.setNotes(notes);
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent == null) {
            return null;
        }

        BeanUtils.copyProperties(student, existingStudent, "id");

        List<Material> materials = getMaterialsFromIds(student.getMaterialsIds());
        List<Note> notes = getNotesFromIds(student.getNotesIds());

        existingStudent.setMaterials(materials);
        existingStudent.setNotes(notes);

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getByCpf(String cpf) {
        return studentRepository.findByCpf(cpf);
    }

    private List<Material> getMaterialsFromIds(List<String> materialsIds) {
        return materialsIds.stream()
                .map(materialsRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private List<Note> getNotesFromIds(List<String> notesIds) {
        return notesIds.stream()
                .map(noteRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}

// public class StudentService {

// @Autowired
// private StudentRepository studentRepository;

// @Autowired
// private MaterialsRepository materialsRepository;

// @Autowired
// private NoteRepository noteRepository;

// public List<Student> getAllStudents() {
// return studentRepository.findAll();
// }

// public Student getStudentById(String id) {
// return studentRepository.findById(id).orElse(null);
// }

// public Student createStudent(Student student) {
// List<String> materialsIds = student.getMaterialsIds();
// List<String> notesIds = student.getNotesIds();
// List<Material> materials = new ArrayList<>();
// List<Note> notes = new ArrayList<>();

// for (String materialId : materialsIds) {
// Material material = materialsRepository.findById(materialId).orElse(null);
// if (material != null) {
// materials.add(material);
// }
// }

// for (String noteId : notesIds) {
// Note note = noteRepository.findById(noteId).orElse(null);
// if (note != null) {
// notes.add(note);
// }
// }

// student.setMaterials(materials);
// student.setNotes(notes);
// return studentRepository.save(student);
// }

// public Student updateStudent(String id, Student student) {
// Student existingStudent = studentRepository.findById(id).orElse(null);
// if (existingStudent == null) {
// return null;
// }

// existingStudent.setName(student.getName());
// existingStudent.setSobrenome(student.getSobrenome());
// existingStudent.setCpf(student.getCpf());

// List<String> materialsIds = student.getMaterialsIds();
// List<String> notesIds = student.getNotesIds();
// List<Material> materials = new ArrayList<>();
// List<Note> notes = new ArrayList<>();

// for (String materialsId : materialsIds) {
// Material material = materialsRepository.findById(id).orElse(null);
// if (material != null) {
// materials.add(material);
// }
// }

// for (String noteId : notesIds) {
// Note note = noteRepository.findById(noteId).orElse(null);
// if (note != null) {
// notes.add(note);
// }
// }

// existingStudent.setMaterials(materials);
// existingStudent.setNotes(notes);

// return studentRepository.save(existingStudent);
// }

// public void deleteStudent(String id) {
// studentRepository.deleteById(id);
// }

// public List<Student> getByCpf(String cpf) {
// return studentRepository.findByCpf(cpf);
// }
// }
