package tutko.spring.dto;


import org.springframework.stereotype.Service;
import tutko.spring.entity.MedicalRecordEntity;
import tutko.spring.entity.PatientEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordMapper {

    public MedicalRecordDTO toDTO(MedicalRecordEntity medicalRecord) {
        if (medicalRecord == null) { return null; }
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        medicalRecordDTO.setRecordId(medicalRecord.getRecordId());
        medicalRecordDTO.setRecordDetails(medicalRecord.getRecordDetails());
        if (medicalRecord.getPatientEntity() != null) {
            medicalRecordDTO.setPatientId(medicalRecord.getPatientEntity().getPatientId());
        }
        return medicalRecordDTO;
    }

    public MedicalRecordEntity toEntity(MedicalRecordDTO medicalRecordDTO) {
        if (medicalRecordDTO == null) { return null; }
        MedicalRecordEntity medicalRecordEntity = new MedicalRecordEntity();
        medicalRecordEntity.setRecordDetails(medicalRecordDTO.getRecordDetails());
        medicalRecordEntity.setRecordId(medicalRecordDTO.getRecordId());
        medicalRecordEntity.setPatientEntity(new PatientEntity().setPatientId(medicalRecordDTO.getPatientId()));
        return medicalRecordEntity;
    }

    public List<MedicalRecordDTO> toDTO(List<MedicalRecordEntity> medicalRecordEntities) {
        return medicalRecordEntities.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<MedicalRecordEntity> toEntity(List<MedicalRecordDTO> medicalRecordDTOs) {
        return medicalRecordDTOs.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
