package tutko.spring.dto;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.sql.Date;


public class PrescriptionDTOTest extends TestCase {
    PrescriptionDTO prescriptionDTOUnderTest = new PrescriptionDTO();
    @Test
    public void testDate_of_prescribedGetterAndSetter() {
        prescriptionDTOUnderTest.setDate_of_prescribed(new Date(1234));
        assertEquals(new Date(1234), prescriptionDTOUnderTest.getDate_of_prescribed());
    }

    @Test
    public void testDosageGetterAndSetter() {
        final String dosage = "dosage";
        prescriptionDTOUnderTest.setDosage(dosage);
        assertEquals(dosage, prescriptionDTOUnderTest.getDosage());
    }

    @Test
    public void testMedicationIDGetterAndSetter() {
        final int medicationID = 0;
        prescriptionDTOUnderTest.setMedicine_id(medicationID);
        assertEquals(medicationID, prescriptionDTOUnderTest.getMedicine_id());
    }

    @Test
    public void testPatientIDGetterAndSetter() {
        final int patientID = 0;
        prescriptionDTOUnderTest.setPatient_id(patientID);
        assertEquals(patientID, prescriptionDTOUnderTest.getPatient_id());
    }

    @Test
    public void testPrescriptionIDGetterAndSetter() {
        final int prescriptionID = 0;
        prescriptionDTOUnderTest.setPrescriptionID(prescriptionID);
        assertEquals(prescriptionID, prescriptionDTOUnderTest.getPrescriptionID());
    }
}