package tutko.spring.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "components")
public class ComponentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_id")
    private int componentId;

    private String name;

    private String description;

    @OneToMany(mappedBy = "componentEntity", fetch = FetchType.EAGER)
    private List<MedicationComponentEntity> medicationComponentEntities;

    public List<MedicationComponentEntity> getMedicationComponentEntities() {
        return medicationComponentEntities;
    }

    public ComponentEntity setMedicationComponentEntities(List<MedicationComponentEntity> medicationComponentEntities) {
        this.medicationComponentEntities = medicationComponentEntities;
        return this;
    }
    public int getComponentId() {
        return componentId;
    }

    public ComponentEntity setComponentId(int componentId) {
        this.componentId = componentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ComponentEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ComponentEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
