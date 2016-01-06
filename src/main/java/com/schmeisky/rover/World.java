package com.schmeisky.rover;

/** The position defines the kind of world we are in. In this kind it is wrapping around after the positive
 *  limit of positions.
 */
public class World {

    private int xlimit, ylimit;

    public World(int xlimit, int ylimit) {
        this.xlimit = xlimit;
        this.ylimit = ylimit;
    }



    public class Position {

        public int x,y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position inDirection(Direction direction) {
            switch (direction) {
                case N: return new Position(x, (y + 1) % ylimit);
                case S: return new Position(x, (y - 1 + ylimit) % ylimit);
                case E: return new Position((x - 1 + xlimit) % xlimit, y);
                case W: return new Position((x + 1) % xlimit, y);
                default: return this;
            }
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (x != position.x) return false;
            return y == position.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}