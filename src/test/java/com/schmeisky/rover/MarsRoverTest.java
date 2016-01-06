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

    private MarsRover getMarsRover(Position position, Direction direction) {
        return MarsRover.createRoverAt(position, direction);
    }

    @Test
    public void movingNorthFacingRoverForwardMovesItOnePositionUp() throws Exception {
        MarsRover rover = getRoverInOrigin();

        rover.enterCommand(new char[] {'f'});

        assertThat(rover.position()).isEqualTo(new Position(0,1));
    }

    @Test
    public void movingNorthFacingRoverBackwardMovesItOnePositionDown() throws Exception {
        MarsRover rover = getRoverInOrigin();

        rover.enterCommand(new char[] {'b'});

        assertThat(rover.position()).isEqualTo(new Position(0, -1));
    }

    @Test
    public void turningRoverLeftChangesDirectionCCW() throws Exception {
        MarsRover rover = getRoverInOrigin();

        rover.enterCommand(new char[] {'l'});

        assertThat(rover.faces()).isEqualTo(Direction.E);
    }

    @Test
    public void turningRoverRightChangesDirectionCW() throws Exception {
        MarsRover rover = getRoverInOrigin();

        rover.enterCommand(new char[] {'r'});

        assertThat(rover.faces()).isEqualTo(Direction.W);
    }


    private MarsRover getRoverInOrigin() {
        Position position = new Position(0,0);
        Direction direction = Direction.N;
        return MarsRover.createRoverAt(position, direction);
    }
}
