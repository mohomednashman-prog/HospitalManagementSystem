package medicalsystem;

public class TreatmentRecord {
    private int patientId;
    private String treatmentSummary;
    private String completedDate;

    public TreatmentRecord(int patientId, String treatmentSummary, String completedDate) {
        this.patientId = patientId;
        this.treatmentSummary = treatmentSummary;
        this.completedDate = completedDate;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getTreatmentSummary() {
        return treatmentSummary;
    }

    public void setTreatmentSummary(String treatmentSummary) {
        this.treatmentSummary = treatmentSummary;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                " | Treatment: " + treatmentSummary +
                " | Date: " + completedDate;
    }
}
