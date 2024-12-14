import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Leaderboard leaderboard = new Leaderboard();

        while (true) {
            System.out.println("\n=== Menu Leaderboard ===");
            System.out.println("1. Tambah Pemain");
            System.out.println("2. Tampilkan Leaderboard");
            System.out.println("3. Cari Pemain");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");

          
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan nama pemain: ");
                        String name = scanner.nextLine();
                        System.out.print("Masukkan skor pemain: ");

                       
                            int score = scanner.nextInt();
                            scanner.nextLine(); 
                            leaderboard.add(name, score);
                            System.out.println("Pemain berhasil ditambahkan.");
                        
                        break;

                    case 2:
                        leaderboard.display();
                        break;

                    case 3:
                        System.out.print("Masukkan nama pemain yang dicari: ");
                        String searchName = scanner.nextLine();
                        leaderboard.find(searchName);
                        break;

                    case 4:
                        System.out.println("Keluar dari program");
                        return;

                    default:
                        System.out.println("Pilihan tidak valid");
                }
        }
    }
}

