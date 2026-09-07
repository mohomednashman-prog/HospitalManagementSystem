package medicalsystem;

public class PatientVisitHistory {
    private VisitNode head;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void addVisit(Visit visit) {
        if (visit == null) {
            System.out.println("Visit cannot be null.");
            return;
        }

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
        } else {
            VisitNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
        System.out.println("Visit added successfully.");
    }

    public boolean removeVisit(int visitId) {
        if (isEmpty()) {
            System.out.println("No visits found for this patient.");
            return false;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            size--;
            System.out.println("Visit removed successfully.");
            return true;
        }

        VisitNode current = head;
        VisitNode previous = null;

        while (current != null && current.visit.getVisitId() != visitId) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Visit ID " + visitId + " was not found.");
            return false;
        }

        previous.next = current.next;
        size--;
        System.out.println("Visit removed successfully.");
        return true;
    }

    public Visit searchVisit(int visitId) {
        VisitNode current = head;

        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }

        return null;
    }

    public void displayHistory() {
        if (isEmpty()) {
            System.out.println("No visit history available.");
            return;
        }

        System.out.println("--- Visit History ---");
        VisitNode current = head;
        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }

    private static class VisitNode {
        private Visit visit;
        private VisitNode next;

        public VisitNode(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }
}
