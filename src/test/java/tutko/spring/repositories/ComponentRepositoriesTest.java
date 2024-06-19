package tutko.spring.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tutko.spring.config.JpaConfig;
import tutko.spring.entity.ComponentEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JpaConfig.class)
class ComponentRepositoriesTest {

    @Autowired
    private ComponentRepositories componentRepositories;

    @Test
    public void testSaveAndFindById() {
        ComponentEntity component = new ComponentEntity();
        component.setName("test");
        component.setDescription("test");

        componentRepositories.save(component);
        ComponentEntity foundEntity = componentRepositories.findById(component.getComponentId()).orElse(null);
        assertNotNull(foundEntity);
        assertEquals(component.getName(), foundEntity.getName());
    }

    @Test
    public void findAll() {
        ComponentEntity component = new ComponentEntity();
        component.setName("test");
        component.setDescription("test");
        componentRepositories.save(component);
        List<ComponentEntity> foundEntities = componentRepositories.findAll();
        assertNotNull(foundEntities);
    }

    @Test
    public void delete(){
        ComponentEntity component = new ComponentEntity();
        component.setName("test");
        component.setDescription("test");
        componentRepositories.save(component);
        componentRepositories.deleteById(component.getComponentId());

        ComponentEntity foundEntity = componentRepositories.findById(component.getComponentId()).orElse(null);
        assertNull(foundEntity);
    }

    @Test
    public void update() {
        ComponentEntity component = new ComponentEntity();
        component.setName("test");
        component.setDescription("test");
        componentRepositories.save(component);

        ComponentEntity foundEntity = componentRepositories.findById(component.getComponentId()).orElse(null);
        foundEntity.setName("test2");
        componentRepositories.save(foundEntity);

        ComponentEntity result = componentRepositories.findById(component.getComponentId()).orElse(null);
        assertNotNull(result.getName(), component.getName());
    }

}