package tutko.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutko.spring.dto.ComponentDTO;
import tutko.spring.dto.ComponentMapper;
import tutko.spring.repositories.ComponentRepositories;

import java.util.List;

@Service
public class ComponentService {

    private final ComponentRepositories componentRepositories;

    @Autowired
    public ComponentService(ComponentRepositories componentRepositories) {
        this.componentRepositories = componentRepositories;
    }

    @Transactional(readOnly = true)
    public ComponentDTO getComponentById(int id) {
        return new ComponentMapper().toDTO(componentRepositories.getReferenceById(id));
    }

    @Transactional(readOnly = true)
    public List<ComponentDTO> getComponents() {
        return new ComponentMapper().toDTO(componentRepositories.findAll());
    }

    public ComponentDTO saveComponent(ComponentDTO componentDTO) {
        return new ComponentMapper().toDTO(componentRepositories.save(new ComponentMapper().toEntity(componentDTO)));
    }

    public void deleteComponent(int id) {
        componentRepositories.deleteById(id);
    }
}
