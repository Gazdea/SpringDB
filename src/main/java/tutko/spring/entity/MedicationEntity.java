package tutko.spring.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medications")
public class MedicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medication_id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "medicationEntity", fetch = FetchType.EAGER)
    private List<MedicationComponentEntity> medicationComponentEntities;

    @OneToMany(mappedBy = "medicationEntity", fetch = FetchType.EAGER)
    private List<PrescriptionEntity> prescriptionEntities;

    public int getMedication_id() {
        return medication_id;
    }

    public MedicationEntity setMedication_id(int medication_id) {
        this.medication_id = medication_id;
        return this;
    }

    public List<MedicationComponentEntity> getMedicationComponentEntities() {
        return medicationComponentEntities;
    }

    public MedicationEntity setMedicationComponentEntities(List<MedicationComponentEntity> medicationComponentEntities) {
        this.medicationComponentEntities = medicationComponentEntities;
        return this;
    }

    public List<PrescriptionEntity> getPrescriptionEntities() {
        return prescriptionEntities;
    }

    public MedicationEntity setPrescriptionEntities(List<PrescriptionEntity> prescriptionEntities) {
        this.prescriptionEntities = prescriptionEntities;
        return this;
    }

    public String getName() {
        return name;
    }

    public MedicationEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MedicationEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
