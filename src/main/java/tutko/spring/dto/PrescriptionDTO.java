package tutko.spring.dto;


import java.sql.Date;

public class PrescriptionDTO {
    private int prescriptionID;
    private Date date_of_prescribed;
    private String dosage;
    private int patient_id;
    private int medicine_id;

    public PrescriptionDTO() {

    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public PrescriptionDTO setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
        return this;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public PrescriptionDTO setPatient_id(int patient_id) {
        this.patient_id = patient_id;
        return this;
    }

    public int getMedicine_id() {
        return medicine_id;
    }

    public PrescriptionDTO setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
        return this;
    }

    public Date getDate_of_prescribed() {
        return date_of_prescribed;
    }

    public PrescriptionDTO setDate_of_prescribed(Date date_of_prescribed) {
        this.date_of_prescribed = date_of_prescribed;
        return this;
    }

    public String getDosage() {
        return dosage;
    }

    public PrescriptionDTO setDosage(String dosage) {
        this.dosage = dosage;
        return this;
    }
}
