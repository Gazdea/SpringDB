package tutko.spring.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "prescriptions")
public class PrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id")
    private int prescriptionId;

    @Column(name = "date_prescribed")
    private Date datePrescribed;

    private String dosage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    PatientEntity patientEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medication_id")
    MedicationEntity medicationEntity;

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public PrescriptionEntity setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
        return this;
    }

    public Date getDatePrescribed() {
        return datePrescribed;
    }

    public PrescriptionEntity setDatePrescribed(Date datePrescribed) {
        this.datePrescribed = datePrescribed;
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
