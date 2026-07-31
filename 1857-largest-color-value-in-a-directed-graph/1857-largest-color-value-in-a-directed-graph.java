class Solution {

    public int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        int[][] ans = new int[n][26];

        int[] queue = new int[n];
        int front = 0;
        int rear = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue[rear++] = i;
            }
        }

        int proc = 0;
        int result = 0;

        while (front < rear) {

            int node = queue[front++];

            ans[node][colors.charAt(node) - 'a']++;
            proc++;
            result = Math.max(result, ans[node][colors.charAt(node) - 'a']);
            for (int val : graph.get(node)) {

                for (int i = 0; i < 26; i++) {
                    ans[val][i] = Math.max(ans[val][i], ans[node][i]);
                }

                indegree[val]--;

                if (indegree[val] == 0) {
                    queue[rear++] = val;
                }
            }
        }

        return proc == n ? result : -1;
    }
}