package tutko.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutko.spring.dto.MedicalRecordDTO;
import tutko.spring.dto.MedicalRecordMapper;
import tutko.spring.repositories.MedicalRecordRepositories;

import java.util.List;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepositories medicalRecordRepositories;

    @Autowired
    public MedicalRecordService(MedicalRecordRepositories medicalRecordRepositories) {
        this.medicalRecordRepositories = medicalRecordRepositories;
    }

    public MedicalRecordDTO getMedicalRecordById(int id) {
        return new MedicalRecordMapper().toDTO(medicalRecordRepositories.getReferenceById(id));
    }

    public List<MedicalRecordDTO> getMedicalRecords() {
        return new MedicalRecordMapper().toDTO(medicalRecordRepositories.findAll());
    }

    public MedicalRecordDTO saveMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        return new MedicalRecordMapper().toDTO(medicalRecordRepositories.save(new MedicalRecordMapper().toEntity(medicalRecordDTO)));
    }

    public void deleteMedicalRecord(int id) {
        medicalRecordRepositories.deleteById(id);
    }
}
