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

    // Method to add a player's score
    public void addScore(String name, int score) {
        root = insert(root, name, score);
    }

    // Insert a player's score into the binary tree (descending order)
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

    // Display the leaderboard (sorted in descending order)
    public void displayLeaderboard() {
        System.out.println("\n=== Leaderboard ===");
        if (root == null) {
            System.out.println("Belum ada skor yang tercatat.\n");
        } else {
            System.out.printf("%-15s %-10s\n", "Nama", "Skor");
            System.out.println("===============================");
            displayDescending(root);
        }
    }

    // Recursive method to display leaderboard in descending order
    private void displayDescending(Node node) {
        if (node == null) return;
        displayDescending(node.left);
        System.out.printf("%-15s %-10d\n", node.name, node.score);
        displayDescending(node.right);
    }

    // Search for a player by name
    public void searchPlayer(String name) {
        Node found = search(root, name);
        if (found != null) {
            System.out.println("Pemain ditemukan: " + found.name + " dengan skor: " + found.score + "\n");
        } else {
            System.out.println("Pemain dengan nama \"" + name + "\" tidak ditemukan.\n");
        }
    }

    // Recursive method to search for a player by name
    private Node search(Node node, String name) {
        if (node == null) return null;

        // Search in the right subtree first to get descending order
        Node foundNode = search(node.right, name);
        if (foundNode != null) return foundNode;

        // If the current node matches the name, return it
        if (node.name.equals(name)) {
            return node;
        }

        return search(node.left, name);
    }
}
