public class Leaderboard {
    private class Node {
        String name;
        int score;
        Node left, right;

        public Node(String name, int score) {
            this.name = name;
            this.score = score;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public Leaderboard() {
        root = null;
    }

    // Menambahkan skor ke tree
    public void addScore(String name, int score) {
        root = insert(root, name, score);
    }

    private Node insert(Node node, String name, int score) {
        if (node == null) {
            return new Node(name, score);
        }
        if (score > node.score) {
            node.left = insert(node.left, name, score);
        } else {
            node.right = insert(node.right, name, score);
        }
        return node;
    }

    // Menampilkan leaderboard (urutan dari skor tertinggi ke terendah)
    public void display() {
        System.out.println("\n=== Leaderboard ===");
        if (root == null) {
            System.out.println("Belum ada skor yang tercatat.");
        } else {
            System.out.printf("%-15s %-10s\n", "Nama", "Skor");
            System.out.println("===============================");
            displayDescending(root);
        }
    }

    private void displayDescending(Node node) {
        if (node == null) return;
        // Menampilkan dari subtree kanan ke kiri untuk urutan skor menurun
        displayDescending(node.left);
        System.out.printf("%-15s %-10d\n", node.name, node.score);
        displayDescending(node.right);
    }
}
