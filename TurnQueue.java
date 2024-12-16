class TurnQueue {
    private Node head;
    private Node tail;

    public void addTurn(String name) {
        Node newNode = new Node(name, 0);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public String nextTurn() {
        if (head == null) {
            return null;
        }
        String name = head.name;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return name;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
