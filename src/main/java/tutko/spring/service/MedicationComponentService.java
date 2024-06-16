package tutko.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutko.spring.dto.MedicationComponentDTO;
import tutko.spring.dto.MedicationComponentMapper;
import tutko.spring.repositories.MedicationComponentRepositories;

@Service
public class MedicationComponentService {

    @Autowired
    private MedicationComponentRepositories medicationComponentRepositories;

    public MedicationComponentDTO saveMedicationComponent(MedicationComponentDTO medicationComponentDTO) {
        return MedicationComponentMapper.toDTO(medicationComponentRepositories.save(MedicationComponentMapper.toEntity(medicationComponentDTO)));
    }

    public void deleteMedicationComponent(int medicationId, int componentId) {
        MedicationComponentDTO medicationComponentDTO = new MedicationComponentDTO();
        medicationComponentDTO.setMedicationId(medicationId);
        medicationComponentDTO.setComponentId(componentId);
        medicationComponentRepositories.delete(MedicationComponentMapper.toEntity(medicationComponentDTO));
    }
}
