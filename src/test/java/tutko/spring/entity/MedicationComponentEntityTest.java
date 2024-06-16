package tutko.spring.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicationComponentEntityTest {

    @Test
    public void test() {
        ComponentEntity componentEntity = new ComponentEntity();

        MedicationEntity medicationEntity = new MedicationEntity();

        MedicationComponentId medicationComponentId = new MedicationComponentId();
        medicationComponentId.setMedicationId(1);
        medicationComponentId.setComponentId(1);

        MedicationComponentEntity med = new MedicationComponentEntity();
        med.setId(medicationComponentId);
        med.setComponentEntity(componentEntity);
        med.setMedicationEntity(medicationEntity);

        assertEquals(medicationComponentId, med.getId());
        assertEquals(componentEntity, med.getComponentEntity());
        assertEquals(medicationEntity, med.getMedicationEntity());
    }

}