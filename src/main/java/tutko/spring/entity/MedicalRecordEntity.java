package tutko.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicalrecords")
public class MedicalRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private int recordId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private PatientEntity patientEntity;

    @Column(name = "record_details")
    private String recordDetails;

    public MedicalRecordEntity() {}

    public int getRecordId() {
        return recordId;
    }

    public MedicalRecordEntity setRecordId(int recordId) {
        this.recordId = recordId;
        return this;
    }

    public String getRecordDetails() {
        return recordDetails;
    }

    public MedicalRecordEntity setRecordDetails(String recordDetails) {
        this.recordDetails = recordDetails;
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
