package tutko.spring.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "components")
public class ComponentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int component_id;

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
    public int getComponent_id() {
        return component_id;
    }

    public ComponentEntity setComponent_id(int component_id) {
        this.component_id = component_id;
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
