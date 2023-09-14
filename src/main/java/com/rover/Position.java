package com.rover;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position moveForward(char direction) {
        switch (direction) {
            case 'N':
                return new Position(x, y+1);
            case 'W':
                return new Position(x-1, y);
            case 'S':
                return new Position(x, y-1);
            case 'E':
                return new Position(x+1, y);
            default:
                throw new IllegalStateException("Unknown Direction");
        }
    }

    public boolean isInside(int x, int y) {
        return this.x <= x && this.y <= y;
    }

    public boolean isOutside(int x, int y) {
        return this.x >= x && this.y >= y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
