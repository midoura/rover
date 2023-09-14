package com.rover;

public class Plateau {
    private int x;
    private int y;

    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isValidMove(Position position) {
        return position.isInside(x, y) && position.isOutside(0, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plateau)) return false;
        Plateau grid = (Plateau) o;
        return x == grid.x &&
                y == grid.y;
    }
}
