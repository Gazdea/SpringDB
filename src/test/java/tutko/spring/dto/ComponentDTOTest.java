package tutko.spring.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ComponentDTOTest {


    @Test
    public void testGetComponentId() {
        ComponentDTO componentDTO = new ComponentDTO();
        componentDTO.setComponent_id(1);

        assertEquals(1, componentDTO.getComponent_id());
    }

    @Test
    public void testGetName() {
        ComponentDTO componentDTO = new ComponentDTO();
        componentDTO.setName("Component A");

        assertEquals("Component A", componentDTO.getName());
    }

    @Test
    public void testGetDescription() {
        ComponentDTO componentDTO = new ComponentDTO();
        componentDTO.setDescription("Description for Component A");

        assertEquals("Description for Component A", componentDTO.getDescription());
    }

    @Test
    public void testSetters() {
        ComponentDTO componentDTO = mock(ComponentDTO.class);
        when(componentDTO.setComponent_id(1)).thenReturn(componentDTO);
        when(componentDTO.setName("Component A")).thenReturn(componentDTO);
        when(componentDTO.setDescription("Description for Component A")).thenReturn(componentDTO);

        assertEquals(componentDTO, componentDTO.setComponent_id(1));
        assertEquals(componentDTO, componentDTO.setName("Component A"));
        assertEquals(componentDTO, componentDTO.setDescription("Description for Component A"));
    }

}