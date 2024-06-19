package tutko.spring.dto;


import java.sql.Date;

public class PrescriptionDTO {
    private int prescriptionID;
    private Date dateOfPrescribed;
    private String dosage;
    private int patientId;
    private int medicineId;

    public PrescriptionDTO() {

    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public PrescriptionDTO setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
        return this;
    }

    public int getPatientId() {
        return patientId;
    }

    public PrescriptionDTO setPatientId(int patientId) {
        this.patientId = patientId;
        return this;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public PrescriptionDTO setMedicineId(int medicineId) {
        this.medicineId = medicineId;
        return this;
    }

    public Date getDateOfPrescribed() {
        return dateOfPrescribed;
    }

    public PrescriptionDTO setDate_of_prescribed(Date dateOfPrescribed) {
        this.dateOfPrescribed = dateOfPrescribed;
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
