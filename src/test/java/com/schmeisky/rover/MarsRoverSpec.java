package com.schmeisky.rover;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MarsRoverSpec {

    //Maybe I should have added this in the beginning, instead of starting with a unit test
    @Test
    public void shouldMakeTravelWithAllCommandsAsExpected() throws Exception {
        MarsRover rover = MarsRover.createRoverAt(new Position(0,0), Direction.N);
        rover.enterCommand("fflfflbbrf");
        assertThat(rover.position()).isEqualTo(new Position(-3, 4));
    }
}
