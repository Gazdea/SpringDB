package tutko.spring.dto;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import tutko.spring.entity.ComponentEntity;

public class ComponentMapperTest extends TestCase {

    @Test
    public void testToDTO() {
        final ComponentDTO componentDTO = new ComponentDTO();
        componentDTO.setComponentId(0);
        componentDTO.setName("name");
        componentDTO.setDescription("description");

        final ComponentEntity expectedResult = new ComponentEntity();
        expectedResult.setComponentId(0);
        expectedResult.setName("name");
        expectedResult.setDescription("description");

        final ComponentDTO result = new ComponentMapper().toDTO(expectedResult);

        assertEquals(componentDTO.getName(), result.getName());
        assertEquals(componentDTO.getDescription(), result.getDescription());
    }

    @Test
    public void testToEntity() {
        final ComponentDTO componentDTO = new ComponentDTO();
        componentDTO.setComponentId(0);
        componentDTO.setName("name");
        componentDTO.setDescription("description");

        final ComponentEntity expectedResult = new ComponentEntity();
        expectedResult.setComponentId(0);
        expectedResult.setName("name");
        expectedResult.setDescription("description");

        final ComponentEntity result = new ComponentMapper().toEntity(componentDTO);

        assertEquals(componentDTO.getName(), result.getName());
        assertEquals(componentDTO.getDescription(), result.getDescription());
    }

}