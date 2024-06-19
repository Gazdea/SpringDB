package tutko.spring.dto;

import org.springframework.stereotype.Service;
import tutko.spring.entity.PatientEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientMapper {

    public PatientDTO toDTO(PatientEntity patient) {
        if (patient == null) {}
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setPatientId(patient.getPatientId());
        patientDTO.setName(patient.getName());
        patientDTO.setBirthDate(patient.getBirthDate());
        if(patient.getMedicalRecordEntity() != null)
        {
           patientDTO.setMedicalRecord(new MedicalRecordMapper().toDTO(patient.getMedicalRecordEntity()));
        }

        return patientDTO;
    }

    public PatientEntity toEntity(PatientDTO patientDTO) {
        if (patientDTO == null) {}
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setPatientId(patientDTO.getPatientId());
        patientEntity.setName(patientDTO.getName());
        patientEntity.setBirthDate(patientDTO.getBirthDate());
        if (patientDTO.getMedicalRecord() != null) {
        patientEntity.setMedicalRecordEntity(new MedicalRecordMapper().toEntity(patientDTO.getMedicalRecord()));
        }
        return patientEntity;
    }

    public List<PatientDTO> toDTO(List<PatientEntity> patientEntities) {
        return patientEntities.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PatientEntity> toEntity(List<PatientDTO> patientDTOs) {
        return patientDTOs.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
