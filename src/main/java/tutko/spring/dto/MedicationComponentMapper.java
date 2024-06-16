package tutko.spring.dto;

import tutko.spring.entity.ComponentEntity;
import tutko.spring.entity.MedicationComponentEntity;
import tutko.spring.entity.MedicationComponentId;
import tutko.spring.entity.MedicationEntity;

import java.util.List;
import java.util.stream.Collectors;

public class MedicationComponentMapper {

    public static MedicationComponentDTO toDTO(MedicationComponentEntity medicationComponentEntity) {
        if (medicationComponentEntity == null) return null;
        MedicationComponentDTO medicationComponentDTO = new MedicationComponentDTO();
        medicationComponentDTO.setComponentId(medicationComponentEntity.getComponentEntity().getComponent_id());
        medicationComponentDTO.setMedicationId(medicationComponentEntity.getMedicationEntity().getMedication_id());
        return medicationComponentDTO;
    }

    public static MedicationComponentEntity toEntity(MedicationComponentDTO medicationComponent) {
        if (medicationComponent == null) return null;
        MedicationComponentEntity medicationComponentEntity = new MedicationComponentEntity();
        MedicationComponentId medicationComponentId = new MedicationComponentId();
        medicationComponentId.setComponentId(medicationComponent.getComponentId());
        medicationComponentId.setMedicationId(medicationComponent.getMedicationId());
        medicationComponentEntity.setId(medicationComponentId);
        medicationComponentEntity.setComponentEntity(new ComponentEntity().setComponent_id(medicationComponentId.getComponentId()));
        medicationComponentEntity.setMedicationEntity(new MedicationEntity().setMedication_id(medicationComponentId.getMedicationId()));
        return medicationComponentEntity;
    }

    public static List<MedicationComponentDTO> toDTO(List<MedicationComponentEntity> medicationComponentEntities) {
        return medicationComponentEntities.stream().map(MedicationComponentMapper::toDTO).collect(Collectors.toList());
    }

    public static List<MedicationComponentEntity> toEntity(List<MedicationComponentDTO> medicationComponentDTOS) {
        return medicationComponentDTOS.stream().map(MedicationComponentMapper::toEntity).collect(Collectors.toList());
    }


}
