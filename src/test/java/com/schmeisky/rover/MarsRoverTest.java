package com.schmeisky.rover;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


/**
 * The rover is an object in a world facing in a direction
 * It is able to receive commands to move or turn, changing position or direction
 */
public class MarsRoverTest {

    World world;

    @Before
    public void before() {
        world = new World(10, 10);
    }
    
    @Test
    public void testRoverIsCreated() throws Exception {
        World.Position position = world.new Position(4,4);
        Direction direction = Direction.N;
        MarsRover rover = getMarsRover(position, direction);

        assertThat(rover.faces()).isEqualTo(direction);
        assertThat(rover.position()).isEqualTo(position);
    }

    @Test
    public void movingNorthFacingRoverForwardMovesItOnePositionUp() throws Exception {
        moveRoverAtOriginAndCheckPosition(world.new Position(4, 5), Direction.N, "f");
    }

    @Test
    public void movingNorthFacingRoverBackwardMovesItOnePositionDown() throws Exception {
        moveRoverAtOriginAndCheckPosition(world.new Position(4, 3), Direction.N, "b");
    }

    @Test
    public void movingEastFacingRoverForwardMovesItOnePositionLeft() throws Exception {
        moveRoverAtOriginAndCheckPosition(world.new Position(3, 4), Direction.E, "f");
    }

    @Test
    public void movingWestFacingRoverForwardMovesItOnePositionRight() throws Exception {
        moveRoverAtOriginAndCheckPosition(world.new Position(5, 4), Direction.W, "f");
    }

    @Test
    public void turningRoverLeftChangesDirectionCCW() throws Exception {
        turnRoverAndCheckDirectionItFaces("l", Direction.E);
    }

    @Test
    public void turningRoverRightChangesDirectionCW() throws Exception {
        turnRoverAndCheckDirectionItFaces("r", Direction.W);
    }

    private void moveRoverAtOriginAndCheckPosition(World.Position position, Direction direction, String movement) {
        MarsRover rover = getRoverAtOrigin(direction);

        rover.enterCommand(movement);

        assertThat(rover.position()).isEqualTo(position);
    }

    private void turnRoverAndCheckDirectionItFaces(String command, Direction direction) {
        MarsRover rover = getNorthFacingRoverAtOrigin();

        rover.enterCommand(command);
        assertThat(rover.faces()).isEqualTo(direction);
    }

    private MarsRover getNorthFacingRoverAtOrigin() {
        return getRoverAtOrigin(Direction.N);
    }

    private MarsRover getRoverAtOrigin(Direction direction) {
        return getMarsRover(world.new Position(4,4), direction);
    }

    private MarsRover getMarsRover(World.Position position, Direction direction) {
        return MarsRover.createRoverAt(position, direction);
    }
}
