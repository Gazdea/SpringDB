package tutko.spring.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicalRecordEntityTest {

    @Test
    public void medicalRecordEntityTest() {
        PatientEntity patientEntity = new PatientEntity();

        MedicalRecordEntity medicalRecordEntity = new MedicalRecordEntity();
        medicalRecordEntity.setRecord_id(1);
        medicalRecordEntity.setRecord_details("test");
        medicalRecordEntity.setPatientEntity(patientEntity);

        assertEquals(1, medicalRecordEntity.getRecord_id());
        assertEquals("test", medicalRecordEntity.getRecord_details());
        assertEquals(patientEntity, medicalRecordEntity.getPatientEntity());
    }
}