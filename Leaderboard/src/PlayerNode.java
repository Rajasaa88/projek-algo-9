public class PlayerNode {
    String name;
    int score;
    PlayerNode next;

    public PlayerNode(String name, int score) {
        this.name = name;
        this.score = score;
        this.next = null;
    }
}
