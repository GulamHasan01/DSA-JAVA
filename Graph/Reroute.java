package Graph;

import java.util.ArrayList;
import java.util.List;

public class Reroute {
    int ans=0;
    public int minReorder(int n, int[][] connections) {

        ArrayList<List<Integer>>forward=new ArrayList<>();
        ArrayList<List<Integer>>backward=new ArrayList<>();
        boolean[] visited= new boolean[n];
        for (int i = 0; i < n; i++) {
            forward.add(new ArrayList<>());
            backward.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            int a=connections[i][0];
            int b=connections[i][1];
            forward.get(a).add(b);
            backward.get(b).add(a);
        }
        dfs(0,forward,backward,visited);

        return ans;
    }

    private void dfs(int node,ArrayList<List<Integer>> forward, ArrayList<List<Integer>> backward, boolean[] visited) {
        visited[node]=true;

        for (int co:forward.get(node)){
            if (!visited[co]){
                ans=ans+1;

                dfs(co,forward,backward,visited);
            }
        }
        for (int co: backward.get(node)){
            if (!visited[co]){
                dfs(co,forward,backward,visited);
            }
        }
    }
}
