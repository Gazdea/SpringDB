package tutko.spring.dto;


import tutko.spring.entity.MedicalRecordEntity;
import tutko.spring.entity.PatientEntity;

import java.util.List;
import java.util.stream.Collectors;

public class MedicalRecordMapper {

    public static MedicalRecordDTO toDTO(MedicalRecordEntity medicalRecord) {
        if (medicalRecord == null) { return null; }
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        medicalRecordDTO.setRecord_id(medicalRecord.getRecord_id());
        medicalRecordDTO.setRecord_details(medicalRecord.getRecord_details());
        if (medicalRecord.getPatientEntity() != null) {
            medicalRecordDTO.setPatient_id(medicalRecord.getPatientEntity().getPatient_id());
        }
        return medicalRecordDTO;
    }

    public static MedicalRecordEntity toEntity(MedicalRecordDTO medicalRecordDTO) {
        if (medicalRecordDTO == null) { return null; }
        MedicalRecordEntity medicalRecordEntity = new MedicalRecordEntity();
        medicalRecordEntity.setRecord_details(medicalRecordDTO.getRecord_details());
        medicalRecordEntity.setRecord_id(medicalRecordDTO.getRecord_id());
        medicalRecordEntity.setPatientEntity(new PatientEntity().setPatient_id(medicalRecordDTO.getPatient_id()));
        return medicalRecordEntity;
    }

    public static List<MedicalRecordDTO> toDTO(List<MedicalRecordEntity> medicalRecordEntities) {
        return medicalRecordEntities.stream().map(MedicalRecordMapper::toDTO).collect(Collectors.toList());
    }

    public static List<MedicalRecordEntity> toEntity(List<MedicalRecordDTO> medicalRecordDTOs) {
        return medicalRecordDTOs.stream().map(MedicalRecordMapper::toEntity).collect(Collectors.toList());
    }
}
