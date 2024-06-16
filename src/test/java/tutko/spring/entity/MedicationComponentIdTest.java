package tutko.spring.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicationComponentIdTest {

    @Test
    public void medicationComponentIdTest() {
        MedicationComponentId id = new MedicationComponentId();
        id.setComponentId(1);
        assertEquals(1, id.getComponentId());
        id.setComponentId(2);
        assertEquals(2, id.getComponentId());
    }

}