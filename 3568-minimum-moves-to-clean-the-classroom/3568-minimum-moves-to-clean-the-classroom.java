class Solution {

    int[][] direction = {
            { 1, 0 },
            { -1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public int minMoves(String[] classroom, int energy) {

        int rows = classroom.length;
        int cols = classroom[0].length();

        char[][] grid = new char[rows][cols];

        int[][] litterId = new int[rows][cols];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int targetL = 0;
        int sx = 0, sy = 0;

        for (int i = 0; i < rows; i++) {
            grid[i] = classroom[i].toCharArray();

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 'L') {
                    litterId[i][j] = targetL++;
                }

                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }

        int masks = 1 << targetL;

        int[][][] best = new int[rows][cols][masks];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(best[i][j], -1);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] { sx, sy, 0, energy, 0 });
        best[sx][sy][0] = energy;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int cx = curr[0];
            int cy = curr[1];
            int steps = curr[2];
            int currEnergy = curr[3];
            int mask = curr[4];

            if (mask == (1 << targetL) - 1) {
                return steps;
            }

            for (int[] dir : direction) {

                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx < 0 || nx >= rows ||
                        ny < 0 || ny >= cols ||
                        grid[nx][ny] == 'X') {
                    continue;
                }

                int nextEnergy = currEnergy - 1;
                int nextMask = mask;

                if (nextEnergy < 0) {
                    continue;
                }

                if (grid[nx][ny] == 'L') {

                    int id = litterId[nx][ny];

                    nextMask = mask | (1 << id);
                }

                if (grid[nx][ny] == 'R') {
                    nextEnergy = energy;
                }

                if (nextEnergy > best[nx][ny][nextMask]) {

                    best[nx][ny][nextMask] = nextEnergy;

                    q.offer(new int[] {
                            nx,
                            ny,
                            steps + 1,
                            nextEnergy,
                            nextMask
                    });
                }
            }
        }

        return -1;
    }
}