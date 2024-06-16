package tutko.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutko.spring.config.SpringConfig;
import tutko.spring.dto.ComponentDTO;
import tutko.spring.dto.ComponentMapper;
import tutko.spring.entity.ComponentEntity;
import tutko.spring.repositories.ComponentRepositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
public class ComponentServiceTest {

    @InjectMocks
    private ComponentService componentService;
    @Mock
    private ComponentRepositories componentRepositories;

    @Test
    void getAllComponents() {
        List<ComponentEntity> components = new ArrayList<>();
        components.add(new ComponentEntity());

        when((componentRepositories.findAll())).thenReturn(components);
        List<ComponentDTO> result = componentService.getComponents();

        assertEquals(components.size(), result.size());
    }

    @Test
    void save(){
        ComponentDTO componentDTO = new ComponentDTO();
        componentDTO.setName("test");
        componentService.saveComponent(componentDTO);
        verify(componentRepositories,times(1)).save(any(ComponentEntity.class));
    }

    @Test
    void deleteComponent(){
        int id = 1;
        componentService.deleteComponent(id);
        verify(componentRepositories,times(1)).deleteById(id);
    }
}
