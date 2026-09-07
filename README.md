# Hospital Management System

This project is a Java console application for managing patient records, emergency queue operations, treatment history, and patient visit history using custom data structures.

## Features

- Patient records stored in a custom Binary Search Tree (BST)
- Search patient by Patient ID
- Delete patient from the BST
- In-order traversal in ascending Patient ID order
- Emergency patient queue using a custom FIFO queue
- Treatment history stored in a custom LIFO stack
- Patient visit history stored in a custom singly linked list
- Validation for invalid input and empty structures

## Project Structure

```text
HospitalManagementSystem/
├── README.md
├── .gitignore
└── src/
    └── main/
        └── java/
            └── medicalsystem/
                ├── Main.java
                ├── Patient.java
                ├── PatientBST.java
                ├── PatientBSTNode.java
                ├── EmergencyQueue.java
                ├── TreatmentRecord.java
                ├── TreatmentStack.java
                ├── Visit.java
                ├── PatientVisitHistory.java
                └── ...
```

## How to Compile

```bash
cd HospitalManagementSystem
javac -d out src/main/java/medicalsystem/*.java
```

## How to Run

```bash
java -cp out medicalsystem.Main
```

## Example Menu Operations

1. Insert patient
2. Search patient by ID
3. Delete patient
4. Display patients in ascending order
5. Enqueue emergency patient
6. Dequeue emergency patient
7. Display emergency queue
8. Push completed treatment
9. Pop most recent treatment
10. Display treatment history
11. Add patient visit
12. Remove visit
13. Search visit
14. Display visit history
15. Exit

## Notes

This project uses custom implementations for the BST, queue, stack, and singly linked list instead of Java built-in collections for each required data structure.
