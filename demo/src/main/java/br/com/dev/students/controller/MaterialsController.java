package br.com.dev.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.dev.students.model.Material;
import br.com.dev.students.service.MaterialService;

@RestController
@RequestMapping("/api/materials")
public class MaterialsController {

    private final MaterialService materialsService;

    @Autowired
    public MaterialsController(MaterialService materialsService) {
        this.materialsService = materialsService;
    }

    @GetMapping
    public List<Material> getAllMaterials() {
        return materialsService.getAllMaterials();
    }

    @GetMapping("/{id}")
    public Material getMaterialById(@PathVariable String materialId) {
        return materialsService.getMaterialById(materialId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Material createMaterial(@RequestBody Material material) {
        return materialsService.createMaterial(material);
    }

    @PutMapping("/{id}")
    public Material updateMaterial(@PathVariable String materialId, @RequestBody Material material) {
        return materialsService.updateMaterial(materialId, material);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterial(@PathVariable String materialId) {
        materialsService.deleteMaterial(materialId);
    }

}
