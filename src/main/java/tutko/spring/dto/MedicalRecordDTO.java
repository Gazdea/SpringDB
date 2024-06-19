package tutko.spring.dto;

public class MedicalRecordDTO {
    private int recordId;
    private String recordDetails;
    private int patientId;

    public MedicalRecordDTO() {

    }

    public int getPatientId() {
        return patientId;
    }

    public MedicalRecordDTO setPatientId(int patientId) {
        this.patientId = patientId;
        return this;
    }

    public int getRecordId() {
        return recordId;
    }

    public MedicalRecordDTO setRecordId(int recordId) {
        this.recordId = recordId;
        return this;
    }

    public String getRecordDetails() {
        return recordDetails;
    }

    public MedicalRecordDTO setRecordDetails(String recordDetails) {
        this.recordDetails = recordDetails;
        return this;
    }

}
