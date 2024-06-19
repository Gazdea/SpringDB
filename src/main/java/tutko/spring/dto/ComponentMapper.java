package tutko.spring.dto;

import org.springframework.stereotype.Service;
import tutko.spring.entity.ComponentEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComponentMapper {

    public ComponentDTO toDTO(ComponentEntity componentEntity) {
        if (componentEntity == null) return null;
        ComponentDTO componentDTO = new ComponentDTO();
        componentDTO.setComponentId(componentEntity.getComponentId());
        componentDTO.setName(componentEntity.getName());
        componentDTO.setDescription(componentEntity.getDescription());

        return componentDTO;
    }

    public ComponentEntity toEntity(ComponentDTO componentDTO) {
        if (componentDTO == null) return null;
        ComponentEntity componentEntity = new ComponentEntity();
        componentEntity.setComponentId(componentDTO.getComponentId());
        componentEntity.setName(componentDTO.getName());
        componentEntity.setDescription(componentDTO.getDescription());

        return componentEntity;
    }

    public List<ComponentDTO> toDTO(List<ComponentEntity> componentEntities) {
        return componentEntities.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ComponentEntity> toEntity(List<ComponentDTO> componentDTOS) {
        return componentDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
