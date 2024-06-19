package tutko.spring.dto;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import tutko.spring.entity.ComponentEntity;
import tutko.spring.entity.MedicationComponentEntity;
import tutko.spring.entity.MedicationComponentId;
import tutko.spring.entity.MedicationEntity;

public class MedicationComponentMapperTest extends TestCase {

    @Test
    public void testToDTO() {
        // Setup
        final MedicationComponentDTO medicationComponent = new MedicationComponentDTO();
        medicationComponent.setMedicationId(0);
        medicationComponent.setComponentId(0);

        final ComponentEntity componentEntity = new ComponentEntity();
        componentEntity.setComponentId(0);

        final MedicationEntity medicationEntity = new MedicationEntity();
        medicationEntity.setMedicationId(0);

        MedicationComponentId medicationComponentId = new MedicationComponentId();
        medicationComponentId.setMedicationId(0);
        medicationComponentId.setComponentId(0);

        final MedicationComponentEntity expectedResult = new MedicationComponentEntity();
        expectedResult.setComponentEntity(componentEntity);
        expectedResult.setMedicationEntity(medicationEntity);
        expectedResult.setId(medicationComponentId);

        // Run the test
        final MedicationComponentDTO result = new MedicationComponentMapper().toDTO(expectedResult);

        // Verify the results
        assertEquals(medicationComponent.getMedicationId(), result.getMedicationId());

    }

    @Test
    public void testToEntity() {
        // Setup
        final MedicationComponentDTO medicationComponent = new MedicationComponentDTO();
        medicationComponent.setMedicationId(0);
        medicationComponent.setComponentId(0);

        final ComponentEntity componentEntity = new ComponentEntity();
        componentEntity.setComponentId(0);

        final MedicationEntity medicationEntity = new MedicationEntity();
        medicationEntity.setMedicationId(0);

        MedicationComponentId medicationComponentId = new MedicationComponentId();
        medicationComponentId.setMedicationId(0);
        medicationComponentId.setComponentId(0);

        final MedicationComponentEntity expectedResult = new MedicationComponentEntity();
        expectedResult.setComponentEntity(componentEntity);
        expectedResult.setMedicationEntity(medicationEntity);
        expectedResult.setId(medicationComponentId);

        // Run the test
        final MedicationComponentEntity result = new MedicationComponentMapper().toEntity(medicationComponent);

        // Verify the results
        assertEquals(expectedResult.getComponentEntity().getComponentId(), result.getComponentEntity().getComponentId());
    }
}