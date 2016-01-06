package com.schmeisky.rover;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


/**
 * The rover is an object in a world facing in a direction
 * It is able to receive commands to move or turn, changing position or direction
 */
public class MarsRoverTest {

    @Test
    public void testRoverIsCreated() throws Exception {
        Position position = new Position(0,0);
        Direction direction = Direction.N;
        MarsRover rover = getMarsRover(position, direction);

        assertThat(rover.faces()).isEqualTo(direction);
        assertThat(rover.position()).isEqualTo(position);
    }

    @Test
    public void movingNorthFacingRoverForwardMovesItOnePositionUp() throws Exception {
        moveRoverAtOriginAndCheckPosition(new Position(0, 1), Direction.N, 'f');
    }

    @Test
    public void movingNorthFacingRoverBackwardMovesItOnePositionDown() throws Exception {
        moveRoverAtOriginAndCheckPosition(new Position(0, -1), Direction.N, 'b');
    }

    @Test
    public void movingEastFacingRoverForwardMovesItOnePositionLeft() throws Exception {
        moveRoverAtOriginAndCheckPosition(new Position(-1, 0), Direction.E, 'f');
    }

    @Test
    public void movingWestFacingRoverForwardMovesItOnePositionRight() throws Exception {
        moveRoverAtOriginAndCheckPosition(new Position(1, 0), Direction.W, 'f');
    }


    private void moveRoverAtOriginAndCheckPosition(Position position, Direction direction, char movement) {
        MarsRover rover = getRoverAtOrigin(direction);

        rover.enterCommand(new char[] {movement});

        assertThat(rover.position()).isEqualTo(position);
    }

    @Test
    public void turningRoverLeftChangesDirectionCCW() throws Exception {
        turnRoverAndCheckDirectionItFaces('l', Direction.E);
    }

    @Test
    public void turningRoverRightChangesDirectionCW() throws Exception {
        turnRoverAndCheckDirectionItFaces('r', Direction.W);
    }

    private void turnRoverAndCheckDirectionItFaces(char command, Direction direction) {
        MarsRover rover = getNorthFacingRoverAtOrigin();

        rover.enterCommand(new char[] {command});
        assertThat(rover.faces()).isEqualTo(direction);
    }

    private MarsRover getNorthFacingRoverAtOrigin() {
        return getRoverAtOrigin(Direction.N);
    }

    private MarsRover getRoverAtOrigin(Direction direction) {
        return getMarsRover(new Position(0,0), direction);
    }

    private MarsRover getMarsRover(Position position, Direction direction) {
        return MarsRover.createRoverAt(position, direction);
    }
}
