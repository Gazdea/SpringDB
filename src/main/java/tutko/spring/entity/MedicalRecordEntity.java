package tutko.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicalrecords")
public class MedicalRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int record_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private PatientEntity patientEntity;

    private String record_details;

    public MedicalRecordEntity() {}

    public int getRecord_id() {
        return record_id;
    }

    public MedicalRecordEntity setRecord_id(int record_id) {
        this.record_id = record_id;
        return this;
    }

    public String getRecord_details() {
        return record_details;
    }

    public MedicalRecordEntity setRecord_details(String record_details) {
        this.record_details = record_details;
        return this;
    }

    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    public MedicalRecordEntity setPatientEntity(PatientEntity patientEntity) {
        this.patientEntity = patientEntity;
        return this;
    }
}
