class Robot {
    int width, height;
    int x, y;
    int dir; // 0=East, 1=North, 2=West, 3=South

    int[][] directions = {
        {1, 0},   // East
        {0, 1},   // North
        {-1, 0},  // West
        {0, -1}   // South
    };

    String[] dirNames = {"East", "North", "West", "South"};

    int perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.perimeter = 2 * (width + height) - 4;
    }

    public void step(int num) {
        num %= perimeter;

        // 🔥 Important fix: full cycle case
        if (num == 0) {
            if (x == 0 && y == 0) {
                dir = 3; // South
            }
            return;
        }

        while (num > 0) {
            int nx = x + directions[dir][0];
            int ny = y + directions[dir][1];

            if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                x = nx;
                y = ny;
                num--;
            } else {
                dir = (dir + 1) % 4;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return dirNames[dir];
    }
}