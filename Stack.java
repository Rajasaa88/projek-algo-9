class Stack{
    private StackNode top;

    public Stack() {
        this.top = null;
    }

    public void push(String item) {
        StackNode newNode = new StackNode(item);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong, tidak ada item untuk di-pop.");
            return null;
        }
        String item = top.data;
        top = top.next;
        return item;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
    }
}