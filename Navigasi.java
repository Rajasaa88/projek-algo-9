public class Navigasi {
    private Stack undoStack = new Stack();
    private Stack redoStack = new Stack();

    public void move(String quest) {
        undoStack.push(quest);
        redoStack.clear();
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada langkah untuk di-undo.");
        } else {
            String lastMove = undoStack.pop();
            redoStack.push(lastMove);
            System.out.println("Undo langkah terakhir: " + lastMove);
        }
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada langkah untuk di-redo.");
        } else {
            String redoMove = redoStack.pop();
            undoStack.push(redoMove);
            System.out.println("Redo langkah: " + redoMove);
        }
    }
}