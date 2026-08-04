class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegre = new int[n];
        int[] queue = new int[n];
        int front = 0;
        int rear = 0;

        int[] depth = new int[n];
        Arrays.fill(depth, 1);

        for (int i = 0; i < n; i++) {
            indegre[favorite[i]]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegre[i] == 0) {
                queue[rear++] = i;
            }
        }
        while (front < rear) {
            int curr = queue[front++];

            int next = favorite[curr];

            depth[next] = Math.max(depth[next], depth[curr] + 1);

            indegre[next]--;

            if (indegre[next] == 0) {
                queue[rear++] = next;
            }
        }
        int maxCycle = 0;
        int sum2Cycles = 0;

        for (int i = 0; i < n; i++) {
            if (indegre[i] == 0)
                continue;

            int cycleLength = 0;
            int curr = i;

            while (indegre[curr] > 0) {
                indegre[curr] = 0;
                cycleLength++;
                curr = favorite[curr];
            }

            if (cycleLength == 2) {

                sum2Cycles += depth[i] + depth[favorite[i]];
            } else {

                maxCycle = Math.max(maxCycle, cycleLength);
            }
        }

        return Math.max(maxCycle, sum2Cycles);
    }
}