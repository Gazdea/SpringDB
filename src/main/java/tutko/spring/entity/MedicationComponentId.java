package tutko.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MedicationComponentId implements Serializable {

    @Column(name = "medication_id")
    private int medicationId;

    @Column(name = "component_id")
    private int componentId;

    public int getMedicationId() {
        return medicationId;
    }

    public MedicationComponentId setMedicationId(int medicationId) {
        this.medicationId = medicationId;
        return this;
    }

    public int getComponentId() {
        return componentId;
    }

    public MedicationComponentId setComponentId(int componentId) {
        this.componentId = componentId;
        return this;
    }
}
