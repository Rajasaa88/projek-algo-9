import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static Leaderboard leaderboard = new Leaderboard(); // Leaderboard global
    public static void main(String[] args) {
        System.out.println("  _____                          _   _                           ");
        System.out.println(" |  __ \\                        | \\ | |");
        System.out.println(" | |__) |___  __ _ _ __   __ _  |  \\| | _____   _____ _ __ ___  ");
        System.out.println(" |  _  // _ \\/ _` | '_ \\ / _` | | . ` |/ _ \\ \\ / / _ \\ '_ ` _ \\");
        System.out.println(" | | \\ \\  __/ (_| | | | | (_| | | |\\  | (_) \\ V /  __/ | | | | | ");
        System.out.println(" |_|  \\_\\___|\\__, |_| |_|\\__,_| |_| \\_|\\___/ \\_/ \\___|_| |_| |_| ");
        System.out.println("              __/ |                                              ");
        System.out.println("             |___/                                               ");
        System.out.println("");
        while (true) {
            System.out.println("\n=== SELAMAT DATANG DI GAME PETUALANGAN REGNA NOVEM ===");
            System.out.println("1. Start Game");
            System.out.println("2. View Leaderboard");
            System.out.println("3. Exit");
            System.out.print("Pilih opsi: ");
            int opsi = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer input

            switch (opsi) {
                case 1:
                    startGame();
                    break;
                case 2:
                    leaderboard.display();
                    break;
                case 3:
                    System.out.println("Terima kasih telah bermain pengelana sejati. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        }
    }

    static void startGame() {
        System.out.print("\nMasukkan nama pemain: ");
        String namaPemain = scanner.nextLine();

        Player player = new Player(namaPemain);
        Navigasi navigasi = new Navigasi();

        System.out.println("\nSelamat datang, " + player.name + "!");
        System.out.println("Petualanganmu dimulai di Desa Kecil...\n");
        System.out.println("Tujuanmu adalah Istana Kerajaan 9 diatas bukit Blue Field\n");
        System.out.println("Berhati-hatilah! tetap berbuat baik dan hadapi tantangan didepan!\n");

        Node root = new Node("Desa Darendale");
        root.left = new Node("Membantu penduduk desa");
        root.right = new Node("Mencari kunci gerbang taman istana");
        root.left.left = new Node("Melawan serigala hutan");
        root.left.right = new Node("Mencari ramuan penyembuh");
        root.right.right = new Node("Menemukan jalan menuju gerbang kerajaan");

        // Eksplorasi Quest
        eksplorQuest(root, player, navigasi);

        // Pertarungan dengan Penjaga Kerajaan
        PenjagaKerajaan penjaga = new PenjagaKerajaan("Cerberus", 500, 50, 30);
        fight(player, penjaga);

        // Tambahkan skor ke leaderboard
        if (player.score > 0) {
            leaderboard.addScore(player.name, player.score);
        }

        System.out.println("\n=== Petualangan Berakhir ===");
    }

    static void eksplorQuest(Node node, Player player, Navigasi navigasi) {
        if (node == null) return;

        navigasi.move(node.quest);
        System.out.println("\nKamu menemukan quest: " + node.quest);
        if (player.stamina <= 0) {
            System.out.println("Stamina habis! Kamu harus istirahat dulu.");
            return;
        }

        System.out.print("Selesaikan quest ini? (y/n): ");
        String jawaban = scanner.nextLine();

        if (jawaban.equalsIgnoreCase("y")) {
            if (miniGame()) {
                System.out.println("Quest \"" + node.quest + "\" selesai!");
                player.completeQuest();
                player.gainXP(20);
                player.decreaseStamina();
                eksplorQuest(node.left, player, navigasi);
                eksplorQuest(node.right, player, navigasi);
            } else {
                System.out.println("Kamu gagal menyelesaikan quest \"" + node.quest + "\".");
            }
        } else {
            System.out.println("Quest \"" + node.quest + "\" dilewati.");
        }
    }

    static boolean miniGame() {
        System.out.println("\n=== Mini-Game: Tebak Angka ===");
        int number = random.nextInt(10) + 1;
        boolean guessedCorrectly = false;

        while (!guessedCorrectly) {
            System.out.print("Tebak angka antara 1-10: ");
            int tebakan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan input buffer

            if (tebakan == number) {
                System.out.println("Tebakan kamu benar!");
                guessedCorrectly = true;
            } else {
                System.out.println("Salah tebak. Coba lagi!");
            }
        }
        return true;
    }

    static void fight(Player player, PenjagaKerajaan penjaga) {
        System.out.println("\n=== Pertarungan dengan " + penjaga.nama + " ===");
        penjaga.tampilkanStatus();

        while (penjaga.HP > 0 && player.isAlive()) {
            System.out.println("\n=== Giliranmu ===");
            System.out.println("1. Serang");
            System.out.println("2. Bertahan");
            System.out.println("3. Istirahat");
            System.out.print("Pilih aksi: ");
            int aksi = scanner.nextInt();

            if (aksi == 1) {
                penjaga.HP -= player.attack();
                System.out.println("Kamu menyerang " + penjaga.nama + "! HP Cerberus: " + penjaga.HP);
            } else if (aksi == 2) {
                player.defend();
            } else {
                player.rest();
            }

            if (penjaga.HP > 0) {
                int damage = penjaga.serangPemain(player.defense);
                player.takeDamage(damage);
            }
        }

        if (player.hp <= 0) {
            System.out.println(player.name + ", kamu kalah! " + penjaga.nama + " terlalu kuat...");
        } else if (penjaga.HP <= 0) {
            System.out.println("\nSelamat! Kamu berhasil mengalahkan " + penjaga.nama + ".");
            System.out.println(player.name + "silahkan masuk kedalam Istana Kerajaan 9");
        }
    }
}
