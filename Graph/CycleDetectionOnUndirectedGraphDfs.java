package Graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionOnUndirectedGraphDfs {
    public boolean cycleDetected(int n,int[][] edges){

        List<List<Integer>>list=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            list.add(new ArrayList<>());
        }
        for (int []edge: edges) {
           int u=edge[0];
           int v=edge[1];
           list.get(u).add(v);
           list.get(v).add(u);
        }
        boolean [] visited=new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
             boolean ans= dfs(list,i,visited,-1);
             if (ans)  return true;
            }
        }
        return false;
    }

    private boolean dfs(List<List<Integer>> list, int node, boolean[] visited, int parent) {
        visited[node]=true;

        for (int neigh:list.get(node)){
            if (!visited[neigh]){
                boolean ans=dfs(list,neigh,visited,node);
                if (ans) return true;
            }else if (visited[neigh] && neigh!=parent) return true;
        }
        return false;
    }

}
