package tutko.spring.dto;


import org.springframework.stereotype.Service;
import tutko.spring.entity.MedicationComponentEntity;
import tutko.spring.entity.MedicationEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationMapper {

    public MedicationDTO toDTO(MedicationEntity medicationEntity) {
        if (medicationEntity == null) return null;
        MedicationDTO medicationDTO = new MedicationDTO();
        medicationDTO.setMedicationId(medicationEntity.getMedicationId());
        medicationDTO.setName(medicationEntity.getName());
        medicationDTO.setDescription(medicationEntity.getDescription());
        medicationDTO.setComponentDTOS(new ComponentMapper().toDTO(medicationEntity
                .getMedicationComponentEntities().stream()
                .map(MedicationComponentEntity::getComponentEntity)
                .collect(Collectors.toList())));
        return medicationDTO;
    }

    public MedicationEntity toEntity(MedicationDTO medicationDTO) {
        if (medicationDTO == null) return null;
        MedicationEntity medicationEntity = new MedicationEntity();
        medicationEntity.setMedicationId(medicationDTO.getMedicationId());
        medicationEntity.setName(medicationDTO.getName());
        medicationEntity.setDescription(medicationDTO.getDescription());
        return medicationEntity;
    }

    public List<MedicationDTO> toDTO(List<MedicationEntity> medicationEntities) {
        return medicationEntities.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<MedicationEntity> toEntitie(List<MedicationDTO> medicationDTOS) {
        return medicationDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
