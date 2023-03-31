package br.com.dev.students.entity;

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

    // @NotNull
    // @min(value = 1,messege"Esse campo aceita apenas valores maiores que 1")
    @Id
    private String id;
    //private String registration;
    // @NotBlank
    private String nome;
    private String sobrenome;
    private String cpf;
}
