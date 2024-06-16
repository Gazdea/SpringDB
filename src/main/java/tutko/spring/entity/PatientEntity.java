package tutko.spring.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "patients")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patient_id;

    private String name;

    private Date birth_date;

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

    public int getPatient_id() {
        return patient_id;
    }

    public PatientEntity setPatient_id(int patient_id) {
        this.patient_id = patient_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PatientEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public PatientEntity setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
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
