package medicalsystem;

public class PatientBST {
    private PatientBSTNode root;

    public PatientBST() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public PatientBSTNode getRoot() {
        return root;
    }

    public boolean insert(Patient patient) {
        if (patient == null) {
            System.out.println("Patient cannot be null.");
            return false;
        }

        if (search(patient.getPatientId()) != null) {
            System.out.println("Duplicate Patient ID: " + patient.getPatientId() + ". Patient already exists.");
            return false;
        }

        root = insertRec(root, patient);
        return true;
    }

    private PatientBSTNode insertRec(PatientBSTNode current, Patient patient) {
        if (current == null) {
            return new PatientBSTNode(patient);
        }

        if (patient.getPatientId() < current.getPatient().getPatientId()) {
            current.setLeft(insertRec(current.getLeft(), patient));
        } else if (patient.getPatientId() > current.getPatient().getPatientId()) {
            current.setRight(insertRec(current.getRight(), patient));
        }

        return current;
    }

    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(PatientBSTNode current, int patientId) {
        if (current == null) {
            return null;
        }

        if (patientId == current.getPatient().getPatientId()) {
            return current.getPatient();
        }

        if (patientId < current.getPatient().getPatientId()) {
            return searchRec(current.getLeft(), patientId);
        }

        return searchRec(current.getRight(), patientId);
    }

    public boolean delete(int patientId) {
        if (isEmpty()) {
            System.out.println("Patient records are empty. Nothing to delete.");
            return false;
        }

        Patient patientToDelete = search(patientId);
        if (patientToDelete == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return false;
        }

        root = deleteRec(root, patientId);
        System.out.println("Patient ID " + patientId + " deleted successfully.");
        return true;
    }

    private PatientBSTNode deleteRec(PatientBSTNode current, int patientId) {
        if (current == null) {
            return null;
        }

        if (patientId < current.getPatient().getPatientId()) {
            current.setLeft(deleteRec(current.getLeft(), patientId));
            return current;
        }

        if (patientId > current.getPatient().getPatientId()) {
            current.setRight(deleteRec(current.getRight(), patientId));
            return current;
        }

        // Case 1: leaf node
        if (current.getLeft() == null && current.getRight() == null) {
            return null;
        }

        // Case 2: one child
        if (current.getLeft() == null) {
            return current.getRight();
        }

        if (current.getRight() == null) {
            return current.getLeft();
        }

        // Case 3: two children
        PatientBSTNode successor = findMinNode(current.getRight());
        current.setPatient(successor.getPatient());
        current.setRight(deleteRec(current.getRight(), successor.getPatient().getPatientId()));
        return current;
    }

    private PatientBSTNode findMinNode(PatientBSTNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public void inOrderTraversal() {
        if (isEmpty()) {
            System.out.println("Patient BST is empty.");
            return;
        }

        System.out.println("--- Patient Records in ascending Patient ID order ---");
        inOrderRec(root);
    }

    private void inOrderRec(PatientBSTNode current) {
        if (current == null) {
            return;
        }

        inOrderRec(current.getLeft());
        System.out.println(current.getPatient());
        inOrderRec(current.getRight());
    }
}
