package tutko.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutko.spring.dto.MedicationComponentDTO;
import tutko.spring.dto.MedicationComponentMapper;
import tutko.spring.repositories.MedicationComponentRepositories;

@Service
public class MedicationComponentService {

    private final MedicationComponentRepositories medicationComponentRepositories;

    @Autowired
    public MedicationComponentService(MedicationComponentRepositories medicationComponentRepositories) {
        this.medicationComponentRepositories = medicationComponentRepositories;
    }

    public MedicationComponentDTO saveMedicationComponent(MedicationComponentDTO medicationComponentDTO) {
        return new MedicationComponentMapper().toDTO(medicationComponentRepositories.save(new MedicationComponentMapper().toEntity(medicationComponentDTO)));
    }

    public void deleteMedicationComponent(int medicationId, int componentId) {
        MedicationComponentDTO medicationComponentDTO = new MedicationComponentDTO();
        medicationComponentDTO.setMedicationId(medicationId);
        medicationComponentDTO.setComponentId(componentId);
        medicationComponentRepositories.delete(new MedicationComponentMapper().toEntity(medicationComponentDTO));
    }
}
