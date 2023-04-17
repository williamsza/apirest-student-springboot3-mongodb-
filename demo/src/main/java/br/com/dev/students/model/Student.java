package br.com.dev.students.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "databases_students")
public class Student {

    @Id
    @DBRef // ***************** */
    private String id;
    private String nome;
    private String sobrenome;
    private String cpf;
    @DBRef
    private String noteId;
    @DBRef
    private String materialId;

    // ------------
    public List<String> getMaterialsIds() {
        return null;
    }

    public List<String> getNotesIds() {
        return null;
    }

    public void setMaterials(List<Material> materials) {
    }

    public void setNotes(List<Note> notes) {
    }

    public Object getName() {
        return null;
    }

    public void setName(Object name) {
    }

    // private List<ObjectId> noteId;
    // @DBRef
    // private List<ObjectId> materials;

    // public List<ObjectId> getMaterials() {
    // return materials;
    // }

    // public void setMaterials(List<ObjectId> materials) {
    // this.materials = materials;
    // }

    // getters e setters
}
