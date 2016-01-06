package com.schmeisky.rover;

public class MarsRover {

    private World.Position position;
    private Direction direction;

    private MarsRover(World.Position position, Direction direction) {
        this.direction = direction;
        this.position = position;
    }

    public static MarsRover createRoverAt(World.Position position, Direction direction) {
        return new MarsRover(position, direction);
    }

    public Direction faces() {
        return direction;
    }

    public World.Position position() {
        return position;
    }

    public void enterCommand(String commands) {
        for (char c : commands.toCharArray()) {
            switch (c) {
                case 'f': position = position.inDirection(direction); break;
                case 'b': position = position().inDirection(direction.reverse()); break;
                case 'l': direction = direction.counterClockWise(); break;
                case 'r': direction = direction.clockWise(); break;
                default:
            }
        }
    }


}
