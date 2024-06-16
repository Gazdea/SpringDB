package tutko.spring.dto;

public class MedicalRecordDTO {
    private int record_id;
    private String record_details;
    private int patient_id;
    public MedicalRecordDTO() {

    }

    public int getPatient_id() {
        return patient_id;
    }

    public MedicalRecordDTO setPatient_id(int patient_id) {
        this.patient_id = patient_id;
        return this;
    }

    public int getRecord_id() {
        return record_id;
    }

    public MedicalRecordDTO setRecord_id(int record_id) {
        this.record_id = record_id;
        return this;
    }

    public String getRecord_details() {
        return record_details;
    }

    public MedicalRecordDTO setRecord_details(String record_details) {
        this.record_details = record_details;
        return this;
    }

}
