public class Leaderboard {
    private Node head;

    public void add(String name, int score) {
        Node newNode = new Node(name, score);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        sort(); 
    }

    
    public void sort() {
        if (head == null || head.next == null) {
            return; 
        }

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;

            if (sorted == null || sorted.score < current.score) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.score >= current.score) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        head = sorted; 
    }

    public void display() {
        if (head == null) {
            System.out.println("Leaderboard kosong.");
            return;
        }
        System.out.println("==== Leaderboard ====");
        Node current = head;
        int rank = 1;
        while (current != null) {
            System.out.println(rank + ". " + current.name + " - " + current.score);
            current = current.next;
            rank++;
        }
    }

    public void find(String name) {
        if (head == null) {
            System.out.println("Leaderboard kosong.");
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                System.out.println("Pemain ditemukan: " + current.name + " dengan skor " + current.score);
                return;
            }
            current = current.next;
        }
        System.out.println("Pemain dengan nama \"" + name + "\" tidak ditemukan.");
    }
}