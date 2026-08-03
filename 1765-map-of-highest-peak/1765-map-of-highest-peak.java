class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] ans = new int[n][m];
        int[][] queue = new int[n * m][3];
        int front = 0;
        int rear = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    queue[rear++] = new int[] { i, j, 0 };
                    ans[i][j] = 0;
                }

            }
        }
            while (front < rear) {
                int[] curr = queue[front++];
                int cx = curr[0];
                int cy = curr[1];
                int dis = curr[2];

                for (int[] dir : direction) {
                    int nx = dir[0] + cx;
                    int ny = dir[1] + cy;

                    if (nx < n && ny < m && nx >= 0 && ny >= 0 && ans[nx][ny] > dis + 1) {
                        if (ans[nx][ny] > dis + 1) {
                            ans[nx][ny] = dis + 1;
                            queue[rear++] = new int[] { nx, ny, dis + 1 };
                        }
                    }
                }
            }
        
        return ans;
    }
}