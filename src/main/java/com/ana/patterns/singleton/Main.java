package com.ana.patterns.singleton;

public class Main {
    public static void main(String[] args) {
        Undo undo = Undo.getInstance();

        undo.addCommand("mkdir carpeta");
        undo.addCommand("cd carpeta");

        System.out.println(undo.showHistory());

        undo.undoCommand();

        System.out.println(undo.showHistory());
    }
}
