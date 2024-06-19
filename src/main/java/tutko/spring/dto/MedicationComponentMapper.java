package tutko.spring.dto;

import org.springframework.stereotype.Service;
import tutko.spring.entity.ComponentEntity;
import tutko.spring.entity.MedicationComponentEntity;
import tutko.spring.entity.MedicationComponentId;
import tutko.spring.entity.MedicationEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationComponentMapper {

    public MedicationComponentDTO toDTO(MedicationComponentEntity medicationComponentEntity) {
        if (medicationComponentEntity == null) return null;
        MedicationComponentDTO medicationComponentDTO = new MedicationComponentDTO();
        medicationComponentDTO.setComponentId(medicationComponentEntity.getComponentEntity().getComponentId());
        medicationComponentDTO.setMedicationId(medicationComponentEntity.getMedicationEntity().getMedicationId());
        return medicationComponentDTO;
    }

    public MedicationComponentEntity toEntity(MedicationComponentDTO medicationComponent) {
        if (medicationComponent == null) return null;
        MedicationComponentEntity medicationComponentEntity = new MedicationComponentEntity();
        MedicationComponentId medicationComponentId = new MedicationComponentId();
        medicationComponentId.setComponentId(medicationComponent.getComponentId());
        medicationComponentId.setMedicationId(medicationComponent.getMedicationId());
        medicationComponentEntity.setId(medicationComponentId);
        medicationComponentEntity.setComponentEntity(new ComponentEntity()
                .setComponentId(medicationComponentId.getComponentId()));
        medicationComponentEntity.setMedicationEntity(new MedicationEntity()
                .setMedicationId(medicationComponentId.getMedicationId()));
        return medicationComponentEntity;
    }

    public List<MedicationComponentDTO> toDTO(List<MedicationComponentEntity> medicationComponentEntities) {
        return medicationComponentEntities.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<MedicationComponentEntity> toEntity(List<MedicationComponentDTO> medicationComponentDTOS) {
        return medicationComponentDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }


}
