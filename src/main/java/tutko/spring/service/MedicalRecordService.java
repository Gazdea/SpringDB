package tutko.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutko.spring.dto.MedicalRecordDTO;
import tutko.spring.dto.MedicalRecordMapper;
import tutko.spring.repositories.MedicalRecordRepositories;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepositories medicalRecordRepositories;

    public MedicalRecordDTO getMedicalRecordById(int id) {
        return MedicalRecordMapper.toDTO(medicalRecordRepositories.getReferenceById(id));
    }

    public List<MedicalRecordDTO> getMedicalRecords() {
        return MedicalRecordMapper.toDTO(medicalRecordRepositories.findAll());
    }

    public MedicalRecordDTO saveMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        return MedicalRecordMapper.toDTO(medicalRecordRepositories.save(MedicalRecordMapper.toEntity(medicalRecordDTO)));
    }

    public void deleteMedicalRecord(int id) {
        medicalRecordRepositories.deleteById(id);
    }
}
