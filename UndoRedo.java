//RANIA KERJAIN INI ._.<3
class UndoRedo {
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    public void performAction(String action) {
        undoStack.push(action);
        redoStack.clear();
    }

    public String undo() {
        if (!undoStack.isEmpty()) {
            String action = undoStack.pop();
            redoStack.push(action);
            return action;
        }
        return "No actions to undo.";
    }

    public String redo() {
        if (!redoStack.isEmpty()) {
            String action = redoStack.pop();
            undoStack.push(action);
            return action;
        }
        return "No actions to redo.";
    }
}