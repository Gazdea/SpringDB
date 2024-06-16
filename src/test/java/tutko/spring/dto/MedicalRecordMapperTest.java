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
        medicalRecordDTO.setRecord_id(0);
        medicalRecordDTO.setPatient_id(0);
        medicalRecordDTO.setRecord_details("record_details");

        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setPatient_id(0);

        final MedicalRecordEntity expectedResult = new MedicalRecordEntity();
        expectedResult.setRecord_id(0);
        expectedResult.setPatientEntity(patientEntity);
        expectedResult.setRecord_details("record_details");

        // Run the test
        final MedicalRecordDTO result =  MedicalRecordMapper.toDTO(expectedResult);

        // Verify the results
        assertEquals(result.getRecord_details(), medicalRecordDTO.getRecord_details());
    }

    @Test
    public void testToEntity() {
        // Setup
        final MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        medicalRecordDTO.setRecord_id(0);
        medicalRecordDTO.setPatient_id(0);
        medicalRecordDTO.setRecord_details("record_details");

        final MedicalRecordEntity expectedResult = new MedicalRecordEntity();
        expectedResult.setRecord_id(0);
        expectedResult.setRecord_details("record_details");

        // Run the test
        final MedicalRecordEntity result = MedicalRecordMapper.toEntity(medicalRecordDTO);

        // Verify the results
        assertEquals(expectedResult.getRecord_details(), result.getRecord_details());
    }

}
