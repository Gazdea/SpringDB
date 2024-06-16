package tutko.spring.entity;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class PrescriptionEntityTest {

    @Test
    public void test() {
        PatientEntity patientEntity = new PatientEntity();
        MedicationEntity medicationEntity = new MedicationEntity();

        PrescriptionEntity prescription = new PrescriptionEntity();
        prescription.setPrescription_id(1);
        prescription.setDosage("test");
        prescription.setDate_prescribed(new Date(1234));
        prescription.setPatientEntity(patientEntity);
        prescription.setMedicationEntity(medicationEntity);

        assertEquals(prescription.getPrescription_id(), 1);
        assertEquals(prescription.getDosage(), "test");
        assertEquals(prescription.getDate_prescribed(), new Date(1234));
        assertEquals(prescription.getPatientEntity(), patientEntity);
        assertEquals(prescription.getMedicationEntity(), medicationEntity);
    }

}