public class Leaderboard {
    private PlayerNode head;

    public void add(String name, int score) {
        PlayerNode newNode = new PlayerNode(name, score);
        if (head == null) {
            head = newNode;
        } else {
            PlayerNode current = head;
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

        PlayerNode sorted = null;
        PlayerNode current = head;

        while (current != null) {
            PlayerNode next = current.next;

            if (sorted == null || sorted.score < current.score) {
                current.next = sorted;
                sorted = current;
            } else {
                PlayerNode temp = sorted;
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
        PlayerNode current = head;
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

        PlayerNode current = head;
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
