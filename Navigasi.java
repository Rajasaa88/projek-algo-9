public class Navigasi {
    private Node head;

    public void add(int x, int y) {
        Node newNode = new Node(x, y);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void move(int x, int y) {
        Node newNode = new Node(x, y);
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println("Posisi: (" + current.x + ", " + current.y + ")");
            current = current.next;
        }
    }
}
