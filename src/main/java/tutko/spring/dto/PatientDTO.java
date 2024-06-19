package tutko.spring.dto;

import java.sql.Date;

public class PatientDTO {
    private int patientId;
    private String name;
    private Date birthDate;
    private MedicalRecordDTO medicalRecord;

    public PatientDTO() {

    }

    public MedicalRecordDTO getMedicalRecord() {
        return medicalRecord;
    }

    public PatientDTO setMedicalRecord(MedicalRecordDTO medicalRecord) {
        this.medicalRecord = medicalRecord;
        return this;
    }

    public int getPatientId() {
        return patientId;
    }

    public PatientDTO setPatientId(int patientId) {
        this.patientId = patientId;
        return this;
    }

    public String getName() {
        return name;
    }

    public PatientDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public PatientDTO setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
