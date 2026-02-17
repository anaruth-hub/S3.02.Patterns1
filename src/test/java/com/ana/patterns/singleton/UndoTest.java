package com.ana.patterns.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UndoTest {

    private Undo undo;

    @BeforeEach
    void setUp() {
        undo = Undo.getInstance();
        undo.clearHistory();
    }

    @Test
    void getInstance_shouldReturnSameInstance() {
        Undo u1 = Undo.getInstance();
        Undo u2 = Undo.getInstance();
        assertSame(u1, u2);
    }

    @Test
    void addCommand_shouldStoreCommandsInOrder() {
        undo.addCommand("mkdir carpeta");
        undo.addCommand("cd carpeta");

        assertEquals(2, undo.historySnapshot().size());
        assertEquals("mkdir carpeta", undo.historySnapshot().get(0));
        assertEquals("cd carpeta", undo.historySnapshot().get(1));
    }

    @Test
    void undoCommand_shouldReturnAndRemoveLastCommand() {
        undo.addCommand("mkdir carpeta");
        undo.addCommand("cd carpeta");

        String undone = undo.undoCommand();

        assertEquals("cd carpeta", undone);
        assertEquals("mkdir carpeta", undo.showHistory());
    }

    @Test
    void undoCommand_shouldReturnNullWhenHistoryIsEmpty() {
        assertNull(undo.undoCommand());
    }

    @Test
    void addCommand_shouldRejectBlank() {
        assertThrows(IllegalArgumentException.class, () -> undo.addCommand("   "));
    }

    @Test
    void addCommand_shouldRejectNull() {
        assertThrows(NullPointerException.class, () -> undo.addCommand(null));
    }
}
