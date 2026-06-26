package Graph;

import java.util.ArrayList;
import java.util.List;

public class DFSonGrsaph {
    public static void main(String[] args) {
        int V = 7;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 4},
                {3, 5},
                {4, 5},
                {5, 6}
        };

        System.out.println(dfs(V, edges));

    }
    public static List<Integer> dfs(int V, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        List<Integer> ans = new ArrayList<>();

        dfsHelper(0, adj, visited, ans);

        return ans;
    }

    public static void dfsHelper(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> ans) {
        visited[node]=true;
        ans.add(node);
        for (int neigh : adj.get(node)){
            if(!visited[neigh]) {
                dfsHelper(neigh, adj, visited, ans);
            }
        }

    }
}
