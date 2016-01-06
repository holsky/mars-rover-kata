package com.schmeisky.rover;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MarsRoverSpec {

    @Test
    public void shouldMakeTravelWithAllCommandsAsExpected() throws Exception {
        MarsRover rover = MarsRover.createRoverAt(new Position(0,0), Direction.N);
        rover.enterCommand("fflfflbbrf");
        assertThat(rover.position()).isEqualTo(new Position(-3, 4));
    }
}
