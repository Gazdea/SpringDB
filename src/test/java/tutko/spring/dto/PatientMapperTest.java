package tutko.spring.dto;

import org.junit.jupiter.api.Test;
import tutko.spring.entity.MedicalRecordEntity;
import tutko.spring.entity.MedicationEntity;
import tutko.spring.entity.PatientEntity;
import tutko.spring.entity.PrescriptionEntity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientMapperTest {

    @Test
    public void testToDTO() {
        // Setup
        final PatientDTO patientDTO = new PatientDTO();
        patientDTO.setPatientId(0);
        patientDTO.setName("name");

        final List<PrescriptionEntity> prescriptionEntities = new ArrayList<>();
        final MedicalRecordEntity medicationEntity = new MedicalRecordEntity();

        final PatientEntity expectedResult = new PatientEntity();
        expectedResult.setPatientId(0);
        expectedResult.setName("name");
        expectedResult.setBirthDate(new Date(1234));
        expectedResult.setPrescriptionEntitys(prescriptionEntities);
        expectedResult.setMedicalRecordEntity(medicationEntity);

        // Run the test
        final PatientDTO result = new PatientMapper().toDTO(expectedResult);

        // Verify the results
        assertEquals(result.getName(), expectedResult.getName());
    }

    @Test
    public void testToEntity() {
        // Setup
        final PatientDTO patientDTO = new PatientDTO();

        patientDTO.setPatientId(0);
        patientDTO.setName("name");
        patientDTO.setBirthDate(new Date(1234));

        final List<PrescriptionEntity> prescriptionEntities = new ArrayList<>();
        final MedicalRecordEntity medicationEntity = new MedicalRecordEntity();

        final PatientEntity expectedResult = new PatientEntity();
        expectedResult.setPatientId(0);
        expectedResult.setName("name");
        expectedResult.setBirthDate(new Date(1234));
        expectedResult.setPrescriptionEntitys(prescriptionEntities);
        expectedResult.setMedicalRecordEntity(medicationEntity);

        // Run the test
        final PatientEntity result = new PatientMapper().toEntity(patientDTO);

        // Verify the results
        assertEquals(result.getName(), expectedResult.getName());
    }
}
