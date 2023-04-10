
package br.com.dev.students.studentsnodels;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection = "notes")
public class Note {
    @Id
    //@DBRef
    private String studentId;
    // private String materialId;
    //private List<String> materialId;
    private List<String> noteId;
    private String content;
    private double valor;
    private String date;

    public Note(String studentId, List<String> materialId, List<String> noteId, String content, double valor,
            String date) {
        this.studentId = studentId;
       // this.materialId = materialId;
        this.noteId = noteId;
        this.content = content;
        this.valor = valor;
        this.date = date;
    }

    public Note() {
    }

}
