package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFStraversal {
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

        System.out.println(bfs(V, edges));
    
    }

        public static List<Integer> bfs(int V, int[][] edges) {

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

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[V];

            List<Integer> ans = new ArrayList<>();

            q.offer(0);
            visited[0]=true;

            while(!q.isEmpty()) {
           int curr=q.poll();
           ans.add(curr);
                for (int neighbour : adj.get(curr)) {

                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                        q.offer(neighbour);
                    }
                }
            }

            return ans;
        }

}
