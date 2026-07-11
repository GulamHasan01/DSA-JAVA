class Solution {
    int vertices = 0;
    int edge = 0;

    public int countCompleteComponents(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int sec = edges[i][1];

            adj.get(first).add(sec);
            adj.get(sec).add(first);
        }
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {

                vertices = 0;
                edge = 0;

                dfs(i, adj, visited);

                edge /= 2;

                if (edge == vertices * (vertices - 1) / 2) {
                    count++;
                }
            }

        }
        return count;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        visited[node] = true;
        vertices++;

        // Every neighbor contributes one edge
        edge += adj.get(node).size();

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfs(neigh, adj, visited);
            }
        }
    }

}
