package tutko.spring.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "prescriptions")
public class PrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescription_id;

    private Date date_prescribed;

    private String dosage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    PatientEntity patientEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medication_id")
    MedicationEntity medicationEntity;

    public int getPrescription_id() {
        return prescription_id;
    }

    public PrescriptionEntity setPrescription_id(int prescription_id) {
        this.prescription_id = prescription_id;
        return this;
    }

    public Date getDate_prescribed() {
        return date_prescribed;
    }

    public PrescriptionEntity setDate_prescribed(Date date_prescribed) {
        this.date_prescribed = date_prescribed;
        return this;
    }

    public String getDosage() {
        return dosage;
    }

    public PrescriptionEntity setDosage(String dosage) {
        this.dosage = dosage;
        return this;
    }

    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    public PrescriptionEntity setPatientEntity(PatientEntity patientEntity) {
        this.patientEntity = patientEntity;
        return this;
    }

    public MedicationEntity getMedicationEntity() {
        return medicationEntity;
    }

    public PrescriptionEntity setMedicationEntity(MedicationEntity medicationEntity) {
        this.medicationEntity = medicationEntity;
        return this;
    }
}
