package br.com.dev.students.model;

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
public class Material {
    @Id
    private String materialId;
    private String id;
    
    private String materialName;
    private String description;

    @DBRef
    private Student student;


}
