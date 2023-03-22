package br.com.dev.students.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Student {

    @Id
    private String registration;
    private String nome;
    private String sobrenome;
    private String cpf;
}
