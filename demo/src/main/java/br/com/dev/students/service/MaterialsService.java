package br.com.dev.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.students.model.Materials;
import br.com.dev.students.repository.MaterialsRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Service
public class MaterialsService {
    @Autowired
    private MaterialsRepository materialsRepository;

    public List<Materials> getAllMaterials() {
        return materialsRepository.findAll();
    }

    public Materials getMaterialsById(String id) {
        return materialsRepository.findById(id).orElse(null);
    }

    public Materials createMaterials(Materials materials) {
        return materialsRepository.save(materials);
    }

    public Materials updateMaterials(String id, Materials materials) {
        Materials materialsToUpdate = materialsRepository.findById(id).orElse(null);
        if (materialsToUpdate == null) {
            return null;
        }
        materialsToUpdate.setName(materials.getName());
        materialsToUpdate.setDescription(materials.getDescription());
        return materialsRepository.save(materialsToUpdate);
    }

    public boolean deleteMaterials(String id) {
        Materials materialsToDelete = materialsRepository.findById(id).orElse(null);
        if (materialsToDelete == null) {
            return false;
        }
        materialsRepository.delete(materialsToDelete);
        return true;
    }

}
