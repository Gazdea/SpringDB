package tutko.spring.dto;

import tutko.spring.entity.PatientEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {

    public static PatientDTO toDTO(PatientEntity patient) {
        if (patient == null) {}
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setPatient_id(patient.getPatient_id());
        patientDTO.setName(patient.getName());
        patientDTO.setBirth_date(patient.getBirth_date());
        if(patient.getMedicalRecordEntity() != null)
        {
           patientDTO.setMedical_record(MedicalRecordMapper.toDTO(patient.getMedicalRecordEntity()));
        }

        return patientDTO;
    }

    public static PatientEntity toEntity(PatientDTO patientDTO) {
        if (patientDTO == null) {}
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setPatient_id(patientDTO.getPatient_id());
        patientEntity.setName(patientDTO.getName());
        patientEntity.setBirth_date(patientDTO.getBirth_date());
        if (patientDTO.getMedical_record() != null) {
        patientEntity.setMedicalRecordEntity(MedicalRecordMapper.toEntity(patientDTO.getMedical_record()));
        }
        return patientEntity;
    }

    public static List<PatientDTO> toDTO(List<PatientEntity> patientEntities) {
        return patientEntities.stream().map(PatientMapper::toDTO).collect(Collectors.toList());
    }

    public static List<PatientEntity> toEntity(List<PatientDTO> patientDTOs) {
        return patientDTOs.stream().map(PatientMapper::toEntity).collect(Collectors.toList());
    }
}
