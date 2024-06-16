package tutko.spring.dto;

import tutko.spring.entity.MedicationEntity;
import tutko.spring.entity.PatientEntity;
import tutko.spring.entity.PrescriptionEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PrescriptionMapper {

    public static PrescriptionDTO toDTO(PrescriptionEntity prescription) {
        if (prescription == null) { return null; }
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setPrescriptionID(prescription.getPrescription_id());
        prescriptionDTO.setDosage(prescription.getDosage());
        prescriptionDTO.setDate_of_prescribed(prescription.getDate_prescribed());
        if(prescription.getMedicationEntity() != null) {
            prescriptionDTO.setMedicine_id(prescription.getMedicationEntity().getMedication_id());
        }
        if(prescription.getPatientEntity() != null) {
            prescriptionDTO.setPatient_id(prescription.getPatientEntity().getPatient_id());
        }
        return prescriptionDTO;
    }

    public static PrescriptionEntity toEntity(PrescriptionDTO prescriptionDTO) {
        if (prescriptionDTO == null) { return null; }
        PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
        prescriptionEntity.setPrescription_id(prescriptionDTO.getPrescriptionID());
        prescriptionEntity.setDosage(prescriptionDTO.getDosage());
        prescriptionEntity.setDate_prescribed(prescriptionDTO.getDate_of_prescribed());
        prescriptionEntity.setMedicationEntity(new MedicationEntity().setMedication_id(prescriptionDTO.getMedicine_id()));
        prescriptionEntity.setPatientEntity(new PatientEntity().setPatient_id(prescriptionDTO.getPatient_id()));
        return prescriptionEntity;
    }

    public static List<PrescriptionDTO> toDTO(List<PrescriptionEntity> prescriptionEntities) {
        return prescriptionEntities.stream().map(PrescriptionMapper::toDTO).collect(Collectors.toList());
    }

    public static List<PrescriptionEntity> toEntity(List<PrescriptionDTO> prescriptionDTOS) {
        return prescriptionDTOS.stream().map(PrescriptionMapper::toEntity).collect(Collectors.toList());
    }
}
