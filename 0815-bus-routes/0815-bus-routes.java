class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(target==source) return 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[routes.length];
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int curr = routes[i][j];
                map.computeIfAbsent(curr, k -> new ArrayList<>()).add(i);

                if (routes[i][j] == source) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

        int count = 1;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                for (int j = 0; j < routes[curr].length; j++) {
                    if (routes[curr][j] == target) {
                        return count;
                    } else {
                        for (int val : map.get(routes[curr][j])) {

                            if (!visited[val]) {
                                q.offer(val);
                                visited[val] = true;
                            }
                        }

                    }
                }
            }
            count++;
        }
        return -1;
    }
}