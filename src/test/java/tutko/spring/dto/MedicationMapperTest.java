package tutko.spring.dto;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import tutko.spring.entity.MedicationComponentEntity;
import tutko.spring.entity.MedicationEntity;
import tutko.spring.entity.PrescriptionEntity;

import java.util.ArrayList;
import java.util.List;

public class MedicationMapperTest extends TestCase {
    @Test
    public void testToDTO() {
        // Setup
        final MedicationDTO medicationDTO = new MedicationDTO();
        medicationDTO.setDescription("description");
        medicationDTO.setName("name");

        final List<MedicationComponentEntity> medicationComponentEntity = new ArrayList<>();
        final List<PrescriptionEntity> prescriptionEntity = new ArrayList<>();

        final MedicationEntity expectedResult = new MedicationEntity();
        expectedResult.setDescription("description");
        expectedResult.setName("name");
        expectedResult.setMedicationId(0);
        expectedResult.setMedicationComponentEntities(medicationComponentEntity);
        expectedResult.setPrescriptionEntities(prescriptionEntity);

        // Run the test
        final MedicationDTO result = new MedicationMapper().toDTO(expectedResult);

        // Verify the results
        assertEquals(medicationDTO.getName(), result.getName());
    }

    @Test
    public void testToEntity() {
        // Setup
        final MedicationDTO medicationDTO = new MedicationDTO();
        medicationDTO.setDescription("description");
        medicationDTO.setName("name");

        final List<MedicationComponentEntity> medicationComponentEntity = new ArrayList<>();
        final List<PrescriptionEntity> prescriptionEntity = new ArrayList<>();

        final MedicationEntity expectedResult = new MedicationEntity();
        expectedResult.setDescription("description");
        expectedResult.setName("name");
        expectedResult.setMedicationId(0);
        expectedResult.setMedicationComponentEntities(medicationComponentEntity);
        expectedResult.setPrescriptionEntities(prescriptionEntity);

        // Run the test
        final MedicationEntity result = new MedicationMapper().toEntity(medicationDTO);

        // Verify the results
        assertEquals(expectedResult.getName(), result.getName());
    }
}