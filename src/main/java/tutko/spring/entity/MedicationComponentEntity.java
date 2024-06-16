package tutko.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicationcomponents")
public class MedicationComponentEntity {

    @EmbeddedId
    private MedicationComponentId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("medicationId")
    @JoinColumn(name = "medication_id", insertable = false, updatable = false)
    private MedicationEntity medicationEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("componentId")
    @JoinColumn(name = "component_id", insertable = false, updatable = false)
    private ComponentEntity componentEntity;

    public MedicationComponentId getId() {
        return id;
    }

    public MedicationComponentEntity setId(MedicationComponentId id) {
        this.id = id;
        return this;
    }

    public MedicationEntity getMedicationEntity() {
        return medicationEntity;
    }

    public MedicationComponentEntity setMedicationEntity(MedicationEntity medicationEntity) {
        this.medicationEntity = medicationEntity;
        return this;
    }

    public ComponentEntity getComponentEntity() {
        return componentEntity;
    }

    public MedicationComponentEntity setComponentEntity(ComponentEntity componentEntity) {
        this.componentEntity = componentEntity;
        return this;
    }
}
