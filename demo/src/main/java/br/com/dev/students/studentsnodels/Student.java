package br.com.dev.students.studentsnodels;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection = "databases_students")
public class Student {

    // @NotNull
    // @min(value = 1,messege"Esse campo aceita apenas valores maiores que 1")
    @Id
    private String studentId;
    private List<String> materialId;
    private String nome;
    private String sobrenome;
    private String cpf;
    private List<Note> noteId;

    // @DBRef
   
   
    public Student(String studentId, String nome, String sobrenome, String cpf) {
        this.studentId = studentId;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public Student() {
    }

  
}
