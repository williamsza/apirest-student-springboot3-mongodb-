package br.com.dev.students.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Student {

    @Id
    @NotBlank
    private String registration;
    @NotBlank
    private String nome;
    private String sobrenome;
    private String cpf;
}
