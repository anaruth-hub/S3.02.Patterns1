package com.ana.patterns.singleton;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public final class Undo {

        private static Undo instance;

        private final Stack<String> history = new Stack<>();

        private Undo() {}

        public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

        public void addCommand(String command) {
        Objects.requireNonNull(command, "command cannot be null");
        String normalized = command.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("command cannot be blank");
        }
        history.push(normalized);
    }

        public String undoCommand() {
        if (history.isEmpty()) return null;
        return history.pop();
    }

        public String showHistory() {
        if (history.isEmpty()) return "";
        return String.join(", ", history);
    }

       void clearHistory() {
        history.clear();
    }
      public List<String> historySnapshot() {
        return List.copyOf(history);
    }
}
