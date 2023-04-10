package br.com.dev.students.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import br.com.dev.students.repository.Repository;
import br.com.dev.students.studentsnodels.Material;
import br.com.dev.students.studentsnodels.Student;

@Service
public class MaterialService {
    @Autowired
    private static Repository mateialRepository;

    public List<Student> findAll() {
        return mateialRepository.findAll();
    }

    // public Material insertMaterial(Material material) {
    // mateial.insert(material);
    // return material;

    // }

    // public void remuve(String id) {
    // Optional<Material> material = findById(id);
    // material.ifPresent(value -> mateial.delete(material.get()));

    // }

    // public Material updateMaterial(String id, Material materialData) {
    // Optional<Material> material = findById(id);
    // if (material.isPresent()) {
    // Material newMaterial = material.get();

    // newMaterial.setMaterialId(materialData.getMaterialId());
    // newMaterial.setNome(materialData.getNome());
    // newMaterial.setDescripton(materialData.getDiscription());

    // mateial.save(newMaterial);

    // return newMaterial;
    // }
    // return null;

    // }

    // public Optional<Material> findById(String id) {
    // return null;
    // }

    // public Material create(Material material) {
    // return null;
    // }

    // public void delete(String id) {
    // }

    // public List<Material> findAll() {
    // return null;
    // }

}
