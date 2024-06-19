package tutko.spring.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "patients")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;

    private String name;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne(mappedBy = "patientEntity", fetch = FetchType.EAGER)
    private MedicalRecordEntity medicalRecordEntity;

    @OneToMany(mappedBy = "patientEntity", fetch = FetchType.EAGER)
    private List<PrescriptionEntity> prescriptionEntitys;

    public List<PrescriptionEntity> getPrescriptionEntitys() {
        return prescriptionEntitys;
    }

    public PatientEntity setPrescriptionEntitys(List<PrescriptionEntity> prescriptionEntitys) {
        this.prescriptionEntitys = prescriptionEntitys;
        return this;
    }

    public int getPatientId() {
        return patientId;
    }

    public PatientEntity setPatientId(int patientId) {
        this.patientId = patientId;
        return this;
    }

    public String getName() {
        return name;
    }

    public PatientEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public PatientEntity setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public MedicalRecordEntity getMedicalRecordEntity() {
        return medicalRecordEntity;
    }

    public PatientEntity setMedicalRecordEntity(MedicalRecordEntity medicalRecordEntity) {
        this.medicalRecordEntity = medicalRecordEntity;
        return this;
    }
}
