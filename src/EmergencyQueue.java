package medicalsystem;

public class EmergencyQueue {
    private QueueNode front;
    private QueueNode rear;
    private int size;

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(Patient patient) {
        if (patient == null) {
            System.out.println("Patient cannot be null.");
            return;
        }

        QueueNode newNode = new QueueNode(patient);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Patient " + patient.getName() + " added to emergency queue.");
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient removedPatient = front.patient;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        System.out.println("Dequeued patient: " + removedPatient.getName());
        return removedPatient;
    }

    public Patient peek() {
        if (isEmpty()) {
            return null;
        }
        return front.patient;
    }

    public void displayWaitingPatients() {
        if (isEmpty()) {
            System.out.println("No waiting patients in emergency queue.");
            return;
        }

        System.out.println("--- Emergency Queue (FIFO) ---");
        QueueNode current = front;
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }

    private static class QueueNode {
        private Patient patient;
        private QueueNode next;

        public QueueNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }
}
