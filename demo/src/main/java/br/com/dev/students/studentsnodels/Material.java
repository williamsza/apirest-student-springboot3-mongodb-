package br.com.dev.students.studentsnodels;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Unwrapped.Empty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "materials")
public class Material {

    @Id
    @DBRef
    private String studentId;
    // private List<String> noteId;
    private List<String> materialId;
    private String discription;

    public Material(String studentId, List<String> materialId, String discription) {
        this.studentId = studentId;
        this.materialId = materialId;
        this.discription = discription;
    }

    public Material() {
    }

    public void setDescripton(String discription2) {
    }

    public Object getNome() {
        return null;
    }

    public void setNome(Object nome) {
    }

    public static Material update(String id, Material material) {
        return null;
    }

    public String getId() {
        return null;
    }

}
