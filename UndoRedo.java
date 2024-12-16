class UndoRedo {
    private Node undoTop;
    private Node redoTop;

    public void performAction(String action) {
        Node newNode = new Node(action, 0);
        newNode.next = undoTop;
        undoTop = newNode;
        redoTop = null;
    }

    public String undo() {
        if (undoTop == null) {
            return "No actions to undo.";
        }
        String action = undoTop.name;
        Node newNode = new Node(action, 0);
        newNode.next = redoTop;
        redoTop = newNode;
        undoTop = undoTop.next;
        return action;
    }

    public String redo() {
        if (redoTop == null) {
            return "No actions to redo.";
        }
        String action = redoTop.name;
        Node newNode = new Node(action, 0);
        newNode.next = undoTop;
        undoTop = newNode;
        redoTop = redoTop.next;
        return action;
    }
}
