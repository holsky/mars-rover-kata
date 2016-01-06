package com.schmeisky.rover;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class WorldTest {

    private World world;

    @Before
    public void setUp() throws Exception {
        world = new World(4, 4);
    }

    @Test
    public void testWrappingLeftEdge() {
        moveFromPositionInDirectionResultsIn(world.new Position(0,0), Direction.E, world.new Position(3, 0));
    }

    @Test
    public void testWrappingRightEdge() {
        moveFromPositionInDirectionResultsIn(world.new Position(3,0), Direction.W, world.new Position(0, 0));
    }

    @Test
    public void testWrappingTopEdge() {
        moveFromPositionInDirectionResultsIn(world.new Position(0,3), Direction.N, world.new Position(0, 0));
    }

    //is this a regresssion test??
    @Test
    public void testWrappingBottomEdge() {
        moveFromPositionInDirectionResultsIn(world.new Position(0,0), Direction.S, world.new Position(0, 3));
    }

    private void moveFromPositionInDirectionResultsIn(World.Position start, Direction direction, World.Position expected) {
        assertThat(start.inDirection(direction)).isEqualTo(expected);
    }
}
