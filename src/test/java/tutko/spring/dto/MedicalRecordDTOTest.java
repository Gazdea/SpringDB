package tutko.spring.dto;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class MedicalRecordDTOTest extends TestCase {

        MedicalRecordDTO medicalRecordDTOUnderTest = new MedicalRecordDTO();
    @Test
    public void testRecord_idGetterAndSetter() {
        final int record_id = 0;
        medicalRecordDTOUnderTest.setRecordId(record_id);
        assertEquals(record_id, medicalRecordDTOUnderTest.getPatientId());
    }

    @Test
    public void testPatient_idGetterAndSetter() {
        final int patient_id = 0;
        medicalRecordDTOUnderTest.setPatientId(patient_id);
        assertEquals(patient_id, medicalRecordDTOUnderTest.getPatientId());
    }

    @Test
    public void testRecord_detailsGetterAndSetter() {
        final String record_details = "record_details";
        medicalRecordDTOUnderTest.setRecordDetails(record_details);
        assertEquals(record_details, medicalRecordDTOUnderTest.getRecordDetails());
    }

    @Test
    public void testRecord_idGetterAndSetter1() {
        final int record_id = 0;
        medicalRecordDTOUnderTest.setRecordId(record_id);
        assertEquals(record_id, medicalRecordDTOUnderTest.getRecordId());
    }

}