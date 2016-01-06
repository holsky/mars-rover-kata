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
        moveRoverAtOriginAndCheckPosition('f', new Position(0, 1));
    }

    @Test
    public void movingNorthFacingRoverBackwardMovesItOnePositionDown() throws Exception {
        moveRoverAtOriginAndCheckPosition('b', new Position(0, -1));
    }

    private void moveRoverAtOriginAndCheckPosition(char movement, Position position) {
        MarsRover rover = getRoverInOrigin();
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
        MarsRover rover = getRoverInOrigin();

        rover.enterCommand(new char[] {command});
        assertThat(rover.faces()).isEqualTo(direction);
    }

    private MarsRover getMarsRover(Position position, Direction direction) {
        return MarsRover.createRoverAt(position, direction);
    }

    private MarsRover getRoverInOrigin() {
        return getMarsRover(new Position(0,0), Direction.N);
    }
}
