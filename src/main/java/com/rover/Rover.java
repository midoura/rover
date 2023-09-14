package com.rover;

public class Rover {
    private Plateau plateau;
    private Position position;
    private char direction;

    public Rover(Plateau plateau, Position position, char direction) {
        this.plateau = plateau;
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void processInstructions(String instructions) {
        instructions.chars().mapToObj( c -> (char) c).forEach(this::process);
    }

    private void process(Character instruction) {
        switch (instruction) {
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            case 'M':
                move();
                break;
            default:
                throw new IllegalStateException("Unknown Instruction");
        }
    }

    private void move() {
        if(plateau.isValidMove(position.moveForward(direction))) {
            position = position.moveForward(direction);
        } else{
            throw new IllegalStateException("Cannot move rover - Out of plateau");
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
            default:
                throw new IllegalStateException("Unknown Direction");
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'W':
                direction = 'N';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'E':
                direction = 'S';
                break;
            default:
                throw new IllegalStateException("Unknown Direction");
        }
    }

    @Override
    public String toString() {
        return position.toString() + " " + direction;
    }
}