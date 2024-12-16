public class Node {
    int x, y;
    String name;
    int score;  
    Node next; 

    Node(int x, int y) {
        this.x = x; 
        this.y = y; 
        this.next = null; 
    }

    Node(String name, int score) {
        this.name = name;
        this.score = score;
        this.next = null;
    }
}