package br.com.dev.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.students.model.Material;
import br.com.dev.students.repository.MaterialsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MaterialService {

    private final MaterialsRepository materialsRepository;

    public List<Material> getAllMaterials() {
        return materialsRepository.findAll();
    }

    public Material getMaterialById(String materialId/*id*/) {
        return materialsRepository.findById(materialId).orElse(null);
    }

    public Material createMaterial(Material material) {
        return materialsRepository.save(material);
    }

    public Material updateMaterial(String materialId, Material material) {
        Material materialsToUpdate = materialsRepository.findById(materialId).orElse(null);
        if (materialsToUpdate == null) {
            return null;
        }
        materialsToUpdate.setMaterialName(material.getMaterialName());
        materialsToUpdate.setDescription(material.getDescription());
        return materialsRepository.save(materialsToUpdate);
    }

    public boolean deleteMaterial(String materialId) {
        Material materialsToDelete = materialsRepository.findById(materialId).orElse(null);
        if (materialsToDelete == null) {
            return false;
        }
        materialsRepository.delete(materialsToDelete);
        return true;
    }

}
