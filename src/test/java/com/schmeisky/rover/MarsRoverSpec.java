package com.schmeisky.rover;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MarsRoverSpec {

    World world;

    @Before
    public void before() {
        world = new World(10, 10);
    }

    //Maybe I should have added this in the beginning, instead of starting with a unit test
    @Test
    public void shouldMakeTravelWithAllCommandsAsExpected() throws Exception {
        MarsRover rover = MarsRover.createRoverAt(world.new Position(4,4), Direction.N);
        rover.enterCommand("fflfflbbrf");
        assertThat(rover.position()).isEqualTo(world.new Position(1, 8));
    }
}
