package tutko.spring.dto;

import tutko.spring.entity.ComponentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ComponentMapper {

    public static ComponentDTO toDTO(ComponentEntity componentEntity) {
        if (componentEntity == null) return null;
        ComponentDTO componentDTO = new ComponentDTO();
        componentDTO.setComponent_id(componentEntity.getComponent_id());
        componentDTO.setName(componentEntity.getName());
        componentDTO.setDescription(componentEntity.getDescription());

        return componentDTO;
    }

    public static ComponentEntity toEntity(ComponentDTO componentDTO) {
        if (componentDTO == null) return null;
        ComponentEntity componentEntity = new ComponentEntity();
        componentEntity.setComponent_id(componentDTO.getComponent_id());
        componentEntity.setName(componentDTO.getName());
        componentEntity.setDescription(componentDTO.getDescription());

        return componentEntity;
    }

    public static List<ComponentDTO> toDTO(List<ComponentEntity> componentEntities) {
        return componentEntities.stream().map(ComponentMapper::toDTO).collect(Collectors.toList());
    }

    public static List<ComponentEntity> toEntity(List<ComponentDTO> componentDTOS) {
        return componentDTOS.stream().map(ComponentMapper::toEntity).collect(Collectors.toList());
    }
}
