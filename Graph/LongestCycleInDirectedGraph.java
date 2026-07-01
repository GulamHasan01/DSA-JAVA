package Graph;

import java.util.HashMap;

public class LongestCycleInDirectedGraph {
    int max=-1;
    public int longestCycle(int[] edges) {
        int n=edges.length;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> map=new HashMap<>();
            dfs(map,edges,i,visited,1);
        }
        return max;
    }
    public void dfs(HashMap<Integer,Integer>map,int[] edges,int node,boolean[]visited,int step){
        if(node==-1) return;
        visited[node]=true;
        int ne=edges[node];
        map.put(node,step);
        if(ne!=-1){
            if(!visited[ne]){
                dfs(map,edges,ne,visited,step+1);
            }else{
                if(map.containsKey(ne)){
                    int cycleLength=step-map.get(ne)+1;
                    max=Math.max(max,cycleLength);
                }
            }
        }
        map.remove(node);
    }
}


