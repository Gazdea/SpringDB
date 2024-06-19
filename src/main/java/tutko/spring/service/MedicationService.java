package tutko.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutko.spring.dto.MedicalRecordDTO;
import tutko.spring.dto.MedicationDTO;
import tutko.spring.dto.MedicationMapper;
import tutko.spring.entity.MedicationEntity;
import tutko.spring.repositories.MedicationRepositories;

import java.util.List;

@Service
public class MedicationService {

    private final MedicationRepositories medicationRepositories;

    @Autowired
    public MedicationService(MedicationRepositories medicationRepositories) {
        this.medicationRepositories = medicationRepositories;
    }

    public MedicationDTO getmedicationById(int id) {
        return new MedicationMapper().toDTO(medicationRepositories.getReferenceById(id));
    }

    public List<MedicationDTO> getMedications() {
        return new MedicationMapper().toDTO(medicationRepositories.findAll());
    }

    public MedicationDTO saveMedication(MedicationDTO medicationDTO) {
        return new MedicationMapper().toDTO(medicationRepositories.save(new MedicationMapper().toEntity(medicationDTO)));
    }

    public void deleteMedicationById(int id) {
        medicationRepositories.deleteById(id);
    }
}
