package tutko.spring.dto;

import org.springframework.stereotype.Service;
import tutko.spring.entity.MedicationEntity;
import tutko.spring.entity.PatientEntity;
import tutko.spring.entity.PrescriptionEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionMapper {

    public PrescriptionDTO toDTO(PrescriptionEntity prescription) {
        if (prescription == null) { return null; }
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setPrescriptionID(prescription.getPrescriptionId());
        prescriptionDTO.setDosage(prescription.getDosage());
        prescriptionDTO.setDate_of_prescribed(prescription.getDatePrescribed());
        if(prescription.getMedicationEntity() != null) {
            prescriptionDTO.setMedicineId(prescription.getMedicationEntity().getMedicationId());
        }
        if(prescription.getPatientEntity() != null) {
            prescriptionDTO.setPatientId(prescription.getPatientEntity().getPatientId());
        }
        return prescriptionDTO;
    }

    public PrescriptionEntity toEntity(PrescriptionDTO prescriptionDTO) {
        if (prescriptionDTO == null) { return null; }
        PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
        prescriptionEntity.setPrescriptionId(prescriptionDTO.getPrescriptionID());
        prescriptionEntity.setDosage(prescriptionDTO.getDosage());
        prescriptionEntity.setDatePrescribed(prescriptionDTO.getDateOfPrescribed());
        prescriptionEntity.setMedicationEntity(new MedicationEntity().setMedicationId(prescriptionDTO.getMedicineId()));
        prescriptionEntity.setPatientEntity(new PatientEntity().setPatientId(prescriptionDTO.getPatientId()));
        return prescriptionEntity;
    }

    public List<PrescriptionDTO> toDTO(List<PrescriptionEntity> prescriptionEntities) {
        return prescriptionEntities.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PrescriptionEntity> toEntity(List<PrescriptionDTO> prescriptionDTOS) {
        return prescriptionDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
