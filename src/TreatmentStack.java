package medicalsystem;

public class TreatmentStack {
    private TreatmentNode top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(TreatmentRecord record) {
        if (record == null) {
            System.out.println("Treatment record cannot be null.");
            return;
        }

        TreatmentNode newNode = new TreatmentNode(record);
        newNode.next = top;
        top = newNode;
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment history is empty.");
            return null;
        }

        TreatmentRecord poppedRecord = top.record;
        top = top.next;
        return poppedRecord;
    }

    public TreatmentRecord peek() {
        if (isEmpty()) {
            return null;
        }

        return top.record;
    }

    public void displayTreatmentRecords() {
        if (isEmpty()) {
            System.out.println("No treatment records available.");
            return;
        }

        System.out.println("--- Treatment History (Latest First) ---");
        TreatmentNode current = top;
        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }

    private static class TreatmentNode {
        private TreatmentRecord record;
        private TreatmentNode next;

        public TreatmentNode(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
    }
}
