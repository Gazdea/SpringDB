package tutko.spring.dto;

import java.util.List;

public class MedicationDTO {
    private int medication_id;
    private String name;
    private String description;
    private List<ComponentDTO> componentDTOS;

    public List<ComponentDTO> getComponentDTOS() {

        return componentDTOS;
    }

    public MedicationDTO setComponentDTOS(List<ComponentDTO> componentDTOS) {
        this.componentDTOS = componentDTOS;
        return this;
    }

    public MedicationDTO() {

    }

    public int getMedication_id() {
        return medication_id;
    }

    public MedicationDTO setMedication_id(int medication_id) {
        this.medication_id = medication_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MedicationDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MedicationDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
