package medicalsystem;

public class PatientBSTNode {
    private Patient patient;
    private PatientBSTNode left;
    private PatientBSTNode right;

    public PatientBSTNode(Patient patient) {
        this.patient = patient;
        this.left = null;
        this.right = null;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientBSTNode getLeft() {
        return left;
    }

    public void setLeft(PatientBSTNode left) {
        this.left = left;
    }

    public PatientBSTNode getRight() {
        return right;
    }

    public void setRight(PatientBSTNode right) {
        this.right = right;
    }
}
