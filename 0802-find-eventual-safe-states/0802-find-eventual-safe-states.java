class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] path = new boolean[graph.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                isSafe(i, graph, visited, path);
            }
        }

        for (int i = 0; i < graph.length; i++) {
            if (!path[i]) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSafe(int node, int[][] grid, boolean[] visited, boolean[] path) {
        visited[node] = true;
        path[node] = true;

        for (int num : grid[node]) {
            if (!visited[num]) {
                boolean ans = isSafe(num, grid, visited, path);
                if (ans) {
                    return true;
                }

            } else {
                if (path[num] == true) {
                    return true;
                }
            }
        }
        path[node] = false;
        return false;
    }
}