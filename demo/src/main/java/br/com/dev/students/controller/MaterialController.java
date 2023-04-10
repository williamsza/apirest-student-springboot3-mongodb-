package br.com.dev.students.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.students.service.MaterialService;
//import br.com.dev.students.service.MaterialService;
import br.com.dev.students.service.StudentSevice;
import br.com.dev.students.studentsnodels.Material;
import br.com.dev.students.studentsnodels.Student;

// @CrossOrigin 

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        List<Student> material = materialService.findAll();
        return ResponseEntity.ok(material);
    }



    // @GetMapping("/{materialId}")
    // public ResponseEntity<Optional<Material>> findById(@PathVariable String id) {
    //     Optional<Material> material = materialService.findById(id);
    //     return ResponseEntity.ok(material);
    // }


//     @PostMapping
//     public ResponseEntity<Material> create(@RequestBody Material material) {
//         Material createdMaterial = materialService.create(material);
//         return ResponseEntity.created(URI.create("/materials/" + createdMaterial.getId())).body(createdMaterial);
//     }

//     @PutMapping("/{materialId}")
//     public ResponseEntity<Material> update(@PathVariable String id, @RequestBody Material material) {
//         Material updatedMaterial = Material.update(id, material);
//         return ResponseEntity.ok(updatedMaterial);
//     }

//     @DeleteMapping("/{materialId}")
//     public ResponseEntity<Void> delete(@PathVariable String id) {
//         materialService.delete(id);
//         return ResponseEntity.noContent().build();
//     }
 }
