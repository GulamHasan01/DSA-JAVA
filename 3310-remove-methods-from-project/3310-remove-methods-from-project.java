class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> susEle = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int[] queue = new int[2 * n];
        int front = 0;
        int rear = 0;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < invocations.length; i++) {
            graph.get(invocations[i][0]).add(invocations[i][1]);
        }

        queue[rear++] = k;
        susEle.add(k);

        while (front < rear) {
            int curr = queue[front++];

            for (int num : graph.get(curr)) {
                if (!susEle.contains(num)) {
                    susEle.add(num);
                    queue[rear++] = num;
                }
            }
        }
        boolean flag = false;

        for (int[] edge : invocations) {

            int u = edge[0];
            int v = edge[1];

            if (!susEle.contains(u) && susEle.contains(v)) {
                flag = true;
            }
        }
        if(flag){
            for(int i=0;i<n;i++){
                ans.add(i);
            }
        }else{
            for(int i=0;i<n;i++){
                if(!susEle.contains(i))
                ans.add(i);
            }
        }

        return ans;
    }
}