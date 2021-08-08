class module2 {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.DOWN);
        moveRobot(robot, -10, 20);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
//        for (int i = 0; i < Direction.values().length - 1; i++) {
//            if (robot.getDirection() != Direction.UP) {
//                robot.turnRight();
//            }
//        }
        Direction Direct = robot.getDirection();
        while (Direct != Direction.UP) {
            robot.turnRight();
            Direct = robot.getDirection();
        }
        if (robot.getX() - toX > 0) {
            robot.turnLeft();
            for (int i = robot.getX(); i != toX; i--) {
                robot.stepForward();
            }
        } else {
            robot.turnRight();
            for (int i = robot.getX(); i != toX; i++) {
                robot.stepForward();
            }
        }
        for (int i = 0; i < Direction.values().length - 1; i++) {
            if (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            }
        }
        if (robot.getY() - toY > 0) {
            robot.turnLeft();
            robot.turnLeft();
            for (int i = robot.getY(); i != toY; i--) {
                robot.stepForward();
            }
        } else {
            for (int i = robot.getY(); i != toY; i++) {
                robot.stepForward();
            }

        }
    }
}
