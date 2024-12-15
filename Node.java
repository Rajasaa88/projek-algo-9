public class Node {
    int x, y;
    String name;
    int score;  
    Node next; 

    Node(int x, int y, String name, int score) {
        this.x = x; 
        this.y = y; 
        this.name = name;
        this.score = score;
        this.next = null; 
    }
}
