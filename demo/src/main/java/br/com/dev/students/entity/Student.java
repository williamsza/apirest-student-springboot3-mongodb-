package br.com.dev.students.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int registration;
    private String nome;
    private String sobrenome;
    private String cpf;
}
