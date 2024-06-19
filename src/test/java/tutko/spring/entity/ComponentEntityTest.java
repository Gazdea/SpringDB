package tutko.spring.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComponentEntityTest {

    @Test
    public void testComponentEntity() {
        List<MedicationComponentEntity> medicationComponentEntities = new ArrayList<>();

        ComponentEntity ce = new ComponentEntity();
        ce.setComponentId(1);
        ce.setName("test");
        ce.setDescription("test");
        ce.setMedicationComponentEntities(medicationComponentEntities);

        assertEquals(ce.getComponentId(), 1);
        assertEquals("test", ce.getName());
        assertEquals("test", ce.getDescription());
        assertEquals(medicationComponentEntities, ce.getMedicationComponentEntities());
    }

}