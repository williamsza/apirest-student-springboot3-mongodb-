package br.com.dev.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.students.model.Materials;
import br.com.dev.students.service.MaterialsService;

@RestController
@RequestMapping("/api/materials")
public class MaterialsController {

    @Autowired
    private final MaterialsService materialsService;

    public MaterialsController(MaterialsService materialsService) {
        this.materialsService = materialsService;
    }

    @GetMapping
    public List<Materials> getAllMaterials() {
        return materialsService.getAllMaterials();
    }

    @GetMapping("/{id}")
    public Materials getMaterialsById(@PathVariable String id) {
        return materialsService.getMaterialsById(id);
    }

    @PostMapping
   // @ResponseStatus(HttpStatus.CREATED)
    public Materials createMaterials(@RequestBody Materials materials) {
        return materialsService.createMaterials(materials);
    }

    @PutMapping("/{id}")
    public Materials updateMaterials(@PathVariable String id, @RequestBody Materials materials) {
        return materialsService.updateMaterials(id, materials);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterials(@PathVariable String id) {
        materialsService.deleteMaterials(id);
    }

}
