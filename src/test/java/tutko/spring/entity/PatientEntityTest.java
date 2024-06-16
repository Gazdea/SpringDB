package tutko.spring.entity;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatientEntityTest {

    @Test
    public void test() {
        MedicalRecordEntity medicalRecordEntity = new MedicalRecordEntity();
        List<PrescriptionEntity> prescriptionEntity = new ArrayList<>();

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setPatient_id(1);
        patientEntity.setName("test");
        patientEntity.setBirth_date(new Date(1234));
        patientEntity.setMedicalRecordEntity(medicalRecordEntity);
        patientEntity.setPrescriptionEntitys(prescriptionEntity);

        assertEquals(patientEntity.getPatient_id(), 1);
        assertEquals(patientEntity.getName(), "test");
        assertEquals(patientEntity.getBirth_date(), new Date(1234));
        assertEquals(patientEntity.getMedicalRecordEntity(), medicalRecordEntity);
        assertEquals(patientEntity.getPrescriptionEntitys(), prescriptionEntity);

    }

}