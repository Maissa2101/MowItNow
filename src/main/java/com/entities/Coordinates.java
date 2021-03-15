package com.entities;

import java.util.Objects;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Vérifie si les coordonnées sont à l'intérieur de la pelouse (ne dépassent pas les coordonnées max de la pelouse)
     * @param coordinates
     * @return true si les coordonnées sont à l'intérieur de la pelouse, false sinon
     */
    public boolean isInsideLawn(Coordinates coordinates) {
        return coordinates.getX() >= 0
                && coordinates.getY() >= 0
                && coordinates.getX() <= this.x
                && coordinates.getY() <= this.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Coordinates))
            return false;
        Coordinates that = (Coordinates) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
