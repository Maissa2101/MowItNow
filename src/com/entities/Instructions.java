package com.entities;

public enum Instructions {
    GAUCHE('G'),
    DROITE('D'),
    AVANCE('A');

    private final char instruction;

    Instructions(char move) {
        this.instruction = move;
    }

    public char getInstruction() {
        return instruction;
    }

    @Override
    public String toString() {
        return String.valueOf(instruction);
    }

}
