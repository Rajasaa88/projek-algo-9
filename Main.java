import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static Leaderboard leaderboard = new Leaderboard(); // Leaderboard global

    public static void main(String[] args) {
        System.out.println("==============================================================================================");
        System.out.println("██████╗ ███████╗ ██████╗ ███╗   ██╗ █████╗     ███╗   ██╗ ██████╗ ██╗   ██╗███████╗███╗   ███╗");
        System.out.println("██╔══██╗██╔════╝██╔════╝ ████╗  ██║██╔══██╗    ████╗  ██║██╔═══██╗██║   ██║██╔════╝████╗ ████║");
        System.out.println("██████╔╝█████╗  ██║  ███╗██╔██╗ ██║███████║    ██╔██╗ ██║██║   ██║██║   ██║█████╗  ██╔████╔██║");
        System.out.println("██╔══██╗██╔══╝  ██║   ██║██║╚██╗██║██╔══██║    ██║╚██╗██║██║   ██║╚██╗ ██╔╝██╔══╝  ██║╚██╔╝██║");
        System.out.println("██║  ██║███████╗╚██████╔╝██║ ╚████║██║  ██║    ██║ ╚████║╚██████╔╝ ╚████╔╝ ███████╗██║ ╚═╝ ██║");
        System.out.println("╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═╝    ╚═╝  ╚═══╝ ╚═════╝   ╚═══╝  ╚══════╝╚═╝     ╚═╝");
        System.out.println("                                        Kelompok 9                                       ");
        System.out.println("==============================================================================================");
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
                    leaderboard.displayLeaderboard();
                    System.out.println("1. Search Player");
                    System.out.println("2. Kembali ke Menu Utama");
                    System.out.print("Pilih opsi: ");
                    int Opsi = scanner.nextInt();
                    scanner.nextLine();
                    if (Opsi == 1) {
                        System.out.print("Masukkan nama pemain yang ingin dicari: ");
                        String playerName = scanner.nextLine();
                        leaderboard.searchPlayer(playerName);
                    } else if (Opsi == 2) {

                    } else {
                        System.out.println("Opsi tidak valid. Kembali ke menu utama.");
                    }
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
        System.out.println("Berhati-hatilah! tetap berbuat baik dan hadapi tantangan didepan!");

        while (true) {
            System.out.println("\n=== Menu Petualangan ===");
            System.out.println("1. Eksplorasi Quest");
            System.out.println("2. Lihat Status Pemain");
            System.out.println("3. Keluar dari Game");
            System.out.print("Pilih aksi: ");
            int aksi = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer input

            switch (aksi) {
                case 1:
                    Node root = new Node("Desa Darendale");
                    root.left = new Node("Membantu penduduk desa");
                    root.right = new Node("Mencari kunci gerbang taman istana");
                    root.left.left = new Node("Melawan serigala hutan");
                    root.left.right = new Node("Mencari ramuan penyembuh");
                    root.right.right = new Node("Menemukan jalan menuju gerbang kerajaan");
                    eksplorQuest(root , player, navigasi);
                    break;
                case 2:
                    System.out.println("\nStatus Pemain:");
                    System.out.println("Nama: " + player.name);
                    System.out.println("HP: " + player.hp);
                    System.out.println("XP: " + player.xp);
                    System.out.println("Level: " + player.level);
                    System.out.println("Stamina: " + player.stamina);
                    System.out.println("Score: " + player.score);
                    break;
                case 3:
                    System.out.println("Terima kasih telah bermain. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Aksi tidak valid. Silakan pilih lagi.");
            }
        }
    }

    static void collectQuests(Node node, List<String> quests) {
        if (node == null) return;
        quests.add(node.quest);
        collectQuests(node.left, quests);
        collectQuests(node.right, quests);
    }

    static void manualSort(List<String> quests) {
        for (int i = 0; i < quests.size() - 1; i++) {
            for (int j = 0; j < quests.size() - i - 1; j++) {
                if (quests.get(j).compareTo(quests.get(j + 1)) > 0) {
                    // Swap
                    String temp = quests.get(j);
                    quests.set(j, quests.get(j + 1));
                    quests.set(j + 1, temp);
                }
            }
        }
    }

    static void eksplorQuest(Node node, Player player, Navigasi navigasi) {
        if (node == null) return;

        navigasi.move(node.quest);
        System.out.println("\nKamu menemukan quest: " + node.quest);

        while (true) {
            System.out.println("\nApa yang ingin kamu lakukan?");
            System.out.println("1. Selesaikan quest");
            System.out.println("2. Lewati quest");
            System.out.println("3. Undo Langkah");
            System.out.println("4. Redo Langkah");
            System.out.println("5. Istirahat untuk memulihkan stamina");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan input buffer

            if (pilihan == 1) { // Selesaikan quest
                if (player.stamina > 0) {
                    if (miniGame()) {
                        System.out.println("Quest \"" + node.quest + "\" selesai!");
                        player.completeQuest();
                        player.gainXP(20);
                        player.decreaseStamina();

                        // Cek apakah ini adalah quest "Menemukan jalan menuju gerbang kerajaan"
                        if (node.quest.equals("Menemukan jalan menuju gerbang kerajaan")) {
                            System.out.println("\nKamu telah menemukan jalan menuju gerbang kerajaan!");
                            System.out.println("Bersiaplah menghadapi Cerberus, penjaga gerbang kerajaan!");
                            PenjagaKerajaan cerberus = new PenjagaKerajaan("Cerberus", 500, 50, 30);
                            fight(player, cerberus);
                            return; // Akhiri eksplorasi setelah melawan Cerberus
                        } else {
                            eksplorQuest(node.left, player, navigasi);
                            eksplorQuest(node.right, player, navigasi);
                        }
                    } else {
                        System.out.println("Kamu gagal menyelesaikan quest \"" + node.quest + "\".");
                    }
                    break; // Keluar dari loop setelah mencoba menyelesaikan quest
                } else {
                    System.out.println("Stamina habis! Kamu tidak bisa menyelesaikan quest ini.");
                }
            } else if (pilihan == 2) { // Lewati quest
                System.out.println("Quest \"" + node.quest + "\" dilewati.");
                eksplorQuest(node.left, player, navigasi);
                eksplorQuest(node.right, player, navigasi);
                break; // Keluar dari loop setelah melewati quest
            } else if (pilihan == 3) { // Undo Langkah
                navigasi.undo();
            } else if (pilihan == 4) { // Redo Langkah
                navigasi.redo();
            } else if (pilihan == 5) { // Istirahat untuk memulihkan stamina
                player.rest();
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
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

            if (aksi == 1) { // Serang
                penjaga.HP -= player.attack();
                System.out.println("Kamu menyerang " + penjaga.nama + "! HP Cerberus: " + penjaga.HP);
            } else if (aksi == 2) { // Bertahan
                player.defend();
            } else if (aksi == 3) { // Istirahat
                player.rest();
            } else {
                System.out.println("Pilihan tidak valid.");
            }

            if (penjaga.HP > 0) {
                int damage = penjaga.serangPemain(player.defense);
                player.takeDamage(damage);
            }
        }

        if (player.hp <= 0) {
            System.out.println(player.name + ", kamu kalah! " + penjaga.nama + " terlalu kuat...");
            leaderboard.addScore(player.name, player.score);
        } else if (penjaga.HP <= 0) {
            System.out.println("\nSelamat! Kamu berhasil mengalahkan " + penjaga.nama + ".");
            System.out.println(player.name + ", silakan masuk ke dalam Istana Kerajaan 9.");
            leaderboard.addScore(player.name, player.score);
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
}
