package com.schmeisky.rover;

public class MarsRover {

    private Position position;
    private Direction direction;

    private MarsRover(Position position, Direction direction) {
        this.direction = direction;
        this.position = position;
    }

    public static MarsRover createRoverAt(Position position, Direction direction) {
        return new MarsRover(position, direction);
    }

    public Direction faces() {
        return direction;
    }

    public Position position() {
        return position;
    }

    public void enterCommand(char[] chars) {
        for (char c : chars) {
            switch (c) {
                case 'f': position = position.inDirection(direction); break;
                default:
            }
        }
    }


}
