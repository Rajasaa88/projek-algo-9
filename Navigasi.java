class StackNode {
    String data;
    StackNode next;

    StackNode(String data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
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

class Navigasi {
    private Stack undoStack = new Stack();
    private Stack redoStack = new Stack();
    private String currentQuest;

    public void move(String quest) {
        if (currentQuest != null) {
            undoStack.push(currentQuest);
        }
        currentQuest = quest;
        redoStack.clear();
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada langkah untuk di-undo.");
        } else {
            redoStack.push(currentQuest);
            currentQuest = undoStack.pop(); // Tidak perlu casting ke String
            System.out.println("Undo langkah terakhir: " + currentQuest);
        }
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada langkah untuk di-redo.");
        } else {
            undoStack.push(currentQuest);
            currentQuest = redoStack.pop(); // Tidak perlu casting ke String
            System.out.println("Redo langkah: " + currentQuest);
        }
    }

    public String getCurrentQuest() {
        return currentQuest;
    }
}