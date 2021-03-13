package com.entities;

public enum Orientation {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private final char orientation;

    Orientation(char orientation) {
        this.orientation = orientation;
    }

    public char getOrientation() {
        return orientation;
    }
}
