package com.schmeisky.rover;

public enum Direction {
    N, E, S, W;

    public Direction reverse() {
        switch (this) {
            case N: return S;
            case S: return N;
            case E: return W;
            case W: return E;
            default: return this;
        }
    }

    public Direction counterClockWise() {
        return Direction.values()[(this.ordinal() + 1) % 4];
    }
}
