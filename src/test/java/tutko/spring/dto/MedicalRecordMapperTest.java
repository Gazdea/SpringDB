package tutko.spring.dto;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import tutko.spring.entity.MedicalRecordEntity;
import tutko.spring.entity.PatientEntity;

public class MedicalRecordMapperTest extends TestCase {

    @Test
    public void testToDTO() {
        // Setup
        final MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        medicalRecordDTO.setRecordId(0);
        medicalRecordDTO.setPatientId(0);
        medicalRecordDTO.setRecordDetails("record_details");

        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setPatientId(0);

        final MedicalRecordEntity expectedResult = new MedicalRecordEntity();
        expectedResult.setRecordId(0);
        expectedResult.setPatientEntity(patientEntity);
        expectedResult.setRecordDetails("record_details");

        // Run the test
        final MedicalRecordDTO result = new MedicalRecordMapper().toDTO(expectedResult);

        // Verify the results
        assertEquals(result.getRecordDetails(), medicalRecordDTO.getRecordDetails());
    }

    @Test
    public void testToEntity() {
        // Setup
        final MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        medicalRecordDTO.setRecordId(0);
        medicalRecordDTO.setPatientId(0);
        medicalRecordDTO.setRecordDetails("record_details");

        final MedicalRecordEntity expectedResult = new MedicalRecordEntity();
        expectedResult.setRecordId(0);
        expectedResult.setRecordDetails("record_details");

        // Run the test
        final MedicalRecordEntity result = new MedicalRecordMapper().toEntity(medicalRecordDTO);

        // Verify the results
        assertEquals(expectedResult.getRecordDetails(), result.getRecordDetails());
    }

}
