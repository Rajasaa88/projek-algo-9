import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Leaderboard leaderboard = new Leaderboard();

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
            System.out.println("Selamat datang di Regna Novem!");
            System.out.println("1. Start Game");
            System.out.println("2. View Leaderboard");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Navigasi navigasi = new Navigasi();
                    navigasi.startGame();
                    break;
                case 2:
                    leaderboard.display();
                    break;
                case 3:
                    System.out.println("Exiting the game. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
