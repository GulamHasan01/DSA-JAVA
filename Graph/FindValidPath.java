package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindValidPath {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>>adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer>q=new LinkedList<>();
        boolean[] visited=new boolean[n];
        q.offer(source);
        visited[source]=true;
        while (!q.isEmpty()){
            int curr=q.poll();

            if (curr==destination) return true;
            else{
                for (int neigh:adj.get(curr)){
                    if (!visited[neigh]) {
                        q.offer(neigh);
                        visited[neigh] = true;
                    }
                }
            }
        }
        return false;
    }
}
