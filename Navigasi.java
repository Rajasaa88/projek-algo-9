import java.util.Scanner;

public class Navigasi {
    private Node head;
    private int steps; 

    public Navigasi() {
        this.steps = 0;
    }

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
        steps++;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println("Posisi: (" + current.x + ", " + current.y + ")");
            current = current.next;
        }
    }

    public int startGame() {
        Scanner scanner = new Scanner(System.in);
        int playerX = 0;
        int playerY = 0;
        add(playerX, playerY);

        System.out.println("Permainan dimulai! Anda berada di posisi (0, 0).");

        while (true) {
            System.out.println("\nPilih aksi Anda:");
            System.out.println("1. Bergerak ke atas");
            System.out.println("2. Bergerak ke bawah");
            System.out.println("3. Bergerak ke kiri");
            System.out.println("4. Bergerak ke kanan");
            System.out.println("5. Tampilkan jejak");
            System.out.println("6. Keluar permainan");
            System.out.print("Masukkan pilihan: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    playerY++;
                    move(playerX, playerY);
                    System.out.println("Anda bergerak ke atas. Posisi sekarang: (" + playerX + ", " + playerY + ")");
                    break;
                case 2: 
                    playerY--;
                    move(playerX, playerY);
                    System.out.println("Anda bergerak ke bawah. Posisi sekarang: (" + playerX + ", " + playerY + ")");
                    break;
                case 3: 
                    playerX--;
                    move(playerX, playerY);
                    System.out.println("Anda bergerak ke kiri. Posisi sekarang: (" + playerX + ", " + playerY + ")");
                    break;
                case 4: 
                    playerX++;
                    move(playerX, playerY);
                    System.out.println("Anda bergerak ke kanan. Posisi sekarang: (" + playerX + ", " + playerY + ")");
                    break;
                case 5: 
                    System.out.println("Jejak perjalanan:");
                    print();
                    break;
                case 6: 
                    System.out.println("Keluar dari permainan. Terima kasih telah bermain!");
                    return steps;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
