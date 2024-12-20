public class Navigasi {
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
            currentQuest = (String) undoStack.pop(); // Casting ke String
            System.out.println("Undo langkah terakhir: " + currentQuest);
        }
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada langkah untuk di-redo.");
        } else {
            undoStack.push(currentQuest);
            currentQuest = (String) redoStack.pop(); // Casting ke String
            System.out.println("Redo langkah: " + currentQuest);
        }
    }

    public String getCurrentQuest() {
        return currentQuest;
    }
}