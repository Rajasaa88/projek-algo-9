//RANIA KERJAIN INI ._.<3
class TurnQueue {
    private Queue<String> queue = new LinkedList<>();

    public void addTurn(String name) {
        queue.add(name);
    }

    public String nextTurn() {
        return queue.poll(); 
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}