package br.com.dev.students.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
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
    private String id;
    private String nome;
    private String sobrenome;
    private String cpf;

    private List<ObjectId> noteId;
    private List<ObjectId> materials;
	public List<ObjectId> getMaterials() {
		return materials;
	}
	public void setMaterials(List<ObjectId> materials) {
		this.materials = materials;
	}

   
    // getters e setters
}
