package Graph;

public class CycleDetInDirectedGraph {
    public boolean hasCycle(int[] edges) {

        int n = edges.length;

        boolean[] visited = new boolean[n];
        boolean[] currPath = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                if (dfs(edges, i, visited, currPath))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(int[] edges,
                        int node,
                        boolean[] visited,
                        boolean[] currPath) {

        visited[node] = true;
        currPath[node] = true;

        int neigh = edges[node];

        if (neigh != -1) {

            if (!visited[neigh]) {

                if (dfs(edges, neigh, visited, currPath))
                    return true;

            } else if (currPath[neigh]) {

                return true;
            }
        }

        // Backtracking
        currPath[node] = false;

        return false;
    }


}
