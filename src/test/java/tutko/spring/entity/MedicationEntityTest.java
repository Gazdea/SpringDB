package tutko.spring.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicationEntityTest {

    @Test
    public void testMedicationEntity() {
        List<PrescriptionEntity> prescriptions = new ArrayList<>();
        List<MedicationComponentEntity> medications = new ArrayList<>();

        MedicationEntity med = new MedicationEntity();
        med.setMedication_id(1);
        med.setName("test");
        med.setDescription("test");
        med.setPrescriptionEntities(prescriptions);
        med.setMedicationComponentEntities(medications);

        assertEquals(med.getMedication_id(), 1);
        assertEquals("test", med.getName());
        assertEquals("test", med.getDescription());
        assertEquals(med.getPrescriptionEntities(), prescriptions);
        assertEquals(med.getMedicationComponentEntities(), medications);
    }
}