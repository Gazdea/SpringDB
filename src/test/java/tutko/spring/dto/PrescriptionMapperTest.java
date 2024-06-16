package tutko.spring.dto;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import tutko.spring.entity.MedicationEntity;
import tutko.spring.entity.PatientEntity;
import tutko.spring.entity.PrescriptionEntity;

import java.sql.Date;

public class PrescriptionMapperTest extends TestCase {

    @Test
    public void testToDTO() {
        // Setup
        final PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setPrescriptionID(0);
        prescriptionDTO.setPatient_id(0);
        prescriptionDTO.setMedicine_id(0);
        prescriptionDTO.setDate_of_prescribed(new Date(1234));
        prescriptionDTO.setDosage("dosage");

        final PatientEntity patientEntity = new PatientEntity();
        final MedicationEntity medicationEntity = new MedicationEntity();

        final PrescriptionEntity expectedResult = new PrescriptionEntity();
        expectedResult.setPrescription_id(0);
        expectedResult.setDosage("dosage");
        expectedResult.setPatientEntity(patientEntity);
        expectedResult.setMedicationEntity(medicationEntity);
        expectedResult.setDate_prescribed(new Date(1234));

        // Run the test
        final PrescriptionDTO result = PrescriptionMapper.toDTO(expectedResult);

        // Verify the results
        assertEquals(prescriptionDTO.getDosage(), result.getDosage());
    }

    @Test
    public void testToEntity() {
        // Setup
        final PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setPrescriptionID(0);
        prescriptionDTO.setPatient_id(0);
        prescriptionDTO.setMedicine_id(0);
        prescriptionDTO.setDate_of_prescribed(new Date(1234));
        prescriptionDTO.setDosage("dosage");

        final PatientEntity patientEntity = new PatientEntity();
        final MedicationEntity medicationEntity = new MedicationEntity();

        final PrescriptionEntity expectedResult = new PrescriptionEntity();
        expectedResult.setPrescription_id(0);
        expectedResult.setDosage("dosage");
        expectedResult.setPatientEntity(patientEntity);
        expectedResult.setMedicationEntity(medicationEntity);
        expectedResult.setDate_prescribed(new Date(1234));

        // Run the test
        final PrescriptionEntity result = PrescriptionMapper.toEntity(prescriptionDTO);

        // Verify the results
        assertEquals(expectedResult.getDosage(), result.getDosage());
    }
}