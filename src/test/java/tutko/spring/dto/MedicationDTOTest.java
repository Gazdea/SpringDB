package tutko.spring.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicationDTOTest {

    private MedicationDTO medicationDTOUnderTest = new MedicationDTO();

    @Test
    void testComponentsGetterAndSetter() {
        final List<ComponentDTO> components = Arrays.asList(new ComponentDTO());
        medicationDTOUnderTest.setComponentDTOS(components);
        assertEquals(components, medicationDTOUnderTest.getComponentDTOS());
    }

    @Test
    void testDescriptionGetterAndSetter() {
        final String description = "description";
        medicationDTOUnderTest.setDescription(description);
        assertEquals(description, medicationDTOUnderTest.getDescription());
    }

    @Test
    void testMedication_idGetterAndSetter() {
        final int medication_id = 0;
        medicationDTOUnderTest.setMedicationId(medication_id);
        assertEquals(medication_id, medicationDTOUnderTest.getMedicationId());
    }

    @Test
    void testNameGetterAndSetter() {
        final String name = "name";
        medicationDTOUnderTest.setName(name);
        assertEquals(name, medicationDTOUnderTest.getName());
    }
}
