package medicalsystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientBST patientBST = new PatientBST();
    private static final EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static final TreatmentStack treatmentStack = new TreatmentStack();
    private static int nextVisitId = 1001;

    public static void main(String[] args) {
        showWelcomeMessage();

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt("Select an option: ");

            switch (choice) {
                case 1:
                    insertPatient();
                    break;
                case 2:
                    searchPatientById();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    patientBST.inOrderTraversal();
                    break;
                case 5:
                    enqueueEmergencyPatient();
                    break;
                case 6:
                    dequeueEmergencyPatient();
                    break;
                case 7:
                    emergencyQueue.displayWaitingPatients();
                    break;
                case 8:
                    pushTreatmentRecord();
                    break;
                case 9:
                    popTreatmentRecord();
                    break;
                case 10:
                    treatmentStack.displayTreatmentRecords();
                    break;
                case 11:
                    addPatientVisit();
                    break;
                case 12:
                    removePatientVisit();
                    break;
                case 13:
                    searchPatientVisit();
                    break;
                case 14:
                    displayPatientVisitHistory();
                    break;
                case 15:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 15.");
            }
        }
    }

    private static void showWelcomeMessage() {
        System.out.println("========================================");
        System.out.println("  Hospital Management System");
        System.out.println("  BST, Queue, Stack, Linked List Demo");
        System.out.println("========================================");
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1. Insert patient");
        System.out.println("2. Search patient by Patient ID");
        System.out.println("3. Delete patient");
        System.out.println("4. Display patients in ascending Patient ID order");
        System.out.println("5. Enqueue emergency patient");
        System.out.println("6. Dequeue emergency patient");
        System.out.println("7. Display emergency queue");
        System.out.println("8. Push completed treatment");
        System.out.println("9. Pop most recent treatment");
        System.out.println("10. Display treatment history");
        System.out.println("11. Add patient visit");
        System.out.println("12. Remove visit");
        System.out.println("13. Search visit by Visit ID");
        System.out.println("14. Display patient visit history");
        System.out.println("15. Exit");
    }

    private static void insertPatient() {
        int patientId = readInt("Enter Patient ID: ");
        String name = readNonEmptyString("Enter Name: ");
        int age = readPositiveInt("Enter Age: ");
        String contactNumber = readNonEmptyString("Enter Contact Number: ");
        String medicalCondition = readNonEmptyString("Enter Medical Condition: ");

        Patient patient = new Patient(patientId, name, age, contactNumber, medicalCondition);
        if (patientBST.insert(patient)) {
            System.out.println("Patient inserted successfully.");
        }
    }

    private static void searchPatientById() {
        int patientId = readInt("Enter Patient ID to search: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient with ID " + patientId + " not found.");
        } else {
            System.out.println("Patient found:");
            System.out.println(patient);
        }
    }

    private static void deletePatient() {
        int patientId = readInt("Enter Patient ID to delete: ");
        patientBST.delete(patientId);
    }

    private static void enqueueEmergencyPatient() {
        int patientId = readInt("Enter Patient ID to add to emergency queue: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient ID " + patientId + " does not exist in records.");
            return;
        }

        emergencyQueue.enqueue(patient);
    }

    private static void dequeueEmergencyPatient() {
        Patient patient = emergencyQueue.dequeue();
        if (patient != null) {
            System.out.println("Emergency patient removed: " + patient.getName());
        }
    }

    private static void pushTreatmentRecord() {
        int patientId = readInt("Enter Patient ID for completed treatment: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient ID " + patientId + " does not exist.");
            return;
        }

        String summary = readNonEmptyString("Enter treatment summary: ");
        String date = readNonEmptyString("Enter completion date: ");

        TreatmentRecord record = new TreatmentRecord(patientId, summary, date);
        treatmentStack.push(record);
        System.out.println("Treatment record pushed to stack.");
    }

    private static void popTreatmentRecord() {
        TreatmentRecord record = treatmentStack.pop();
        if (record != null) {
            System.out.println("Popped treatment record:");
            System.out.println(record);
        }
    }

    private static void addPatientVisit() {
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return;
        }

        String visitDate = readNonEmptyString("Enter Visit Date: ");
        String doctorName = readNonEmptyString("Enter Doctor Name: ");
        String diagnosis = readNonEmptyString("Enter Diagnosis: ");
        String treatment = readNonEmptyString("Enter Treatment: ");

        Visit visit = new Visit(nextVisitId++, visitDate, doctorName, diagnosis, treatment);
        patient.getVisitHistory().addVisit(visit);
    }

    private static void removePatientVisit() {
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return;
        }

        int visitId = readInt("Enter Visit ID to remove: ");
        patient.getVisitHistory().removeVisit(visitId);
    }

    private static void searchPatientVisit() {
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return;
        }

        int visitId = readInt("Enter Visit ID to search: ");
        Visit visit = patient.getVisitHistory().searchVisit(visitId);
        if (visit == null) {
            System.out.println("Visit ID " + visitId + " not found for patient " + patientId + ".");
        } else {
            System.out.println("Visit found:");
            System.out.println(visit);
        }
    }

    private static void displayPatientVisitHistory() {
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return;
        }

        patient.getVisitHistory().displayHistory();
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private static int readPositiveInt(String message) {
        while (true) {
            int value = readInt(message);
            if (value > 0) {
                return value;
            }
            System.out.println("Please enter a positive number.");
        }
    }

    private static String readNonEmptyString(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }
}
