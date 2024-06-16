package tutko.spring.dto;


import tutko.spring.entity.MedicationComponentEntity;
import tutko.spring.entity.MedicationEntity;

import java.util.List;
import java.util.stream.Collectors;


public class MedicationMapper {

    public static MedicationDTO toDTO(MedicationEntity medicationEntity) {
        if (medicationEntity == null) return null;
        MedicationDTO medicationDTO = new MedicationDTO();
        medicationDTO.setMedication_id(medicationEntity.getMedication_id());
        medicationDTO.setName(medicationEntity.getName());
        medicationDTO.setDescription(medicationEntity.getDescription());
        medicationDTO.setComponentDTOS(ComponentMapper.toDTO(medicationEntity.getMedicationComponentEntities().stream().map(MedicationComponentEntity::getComponentEntity).collect(Collectors.toList())));
        return medicationDTO;
    }

    public static MedicationEntity toEntity(MedicationDTO medicationDTO) {
        if (medicationDTO == null) return null;
        MedicationEntity medicationEntity = new MedicationEntity();
        medicationEntity.setMedication_id(medicationDTO.getMedication_id());
        medicationEntity.setName(medicationDTO.getName());
        medicationEntity.setDescription(medicationDTO.getDescription());
        return medicationEntity;
    }

    public static List<MedicationDTO> toDTO(List<MedicationEntity> medicationEntities) {
        return medicationEntities.stream().map(MedicationMapper::toDTO).collect(Collectors.toList());
    }

    public static List<MedicationEntity> toEntitie(List<MedicationDTO> medicationDTOS) {
        return medicationDTOS.stream().map(MedicationMapper::toEntity).collect(Collectors.toList());
    }
}
