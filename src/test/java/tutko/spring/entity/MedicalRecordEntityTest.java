package tutko.spring.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicalRecordEntityTest {

    @Test
    public void medicalRecordEntityTest() {
        PatientEntity patientEntity = new PatientEntity();

        MedicalRecordEntity medicalRecordEntity = new MedicalRecordEntity();
        medicalRecordEntity.setRecordId(1);
        medicalRecordEntity.setRecordDetails("test");
        medicalRecordEntity.setPatientEntity(patientEntity);

        assertEquals(1, medicalRecordEntity.getRecordId());
        assertEquals("test", medicalRecordEntity.getRecordDetails());
        assertEquals(patientEntity, medicalRecordEntity.getPatientEntity());
    }
}