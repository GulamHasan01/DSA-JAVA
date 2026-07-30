class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> outmap = new HashMap<>();
        for (int[] num : prerequisites) {
            map.computeIfAbsent(num[0], k -> new ArrayList<>()).add(num[1]);
            outmap.computeIfAbsent(num[1], k -> new ArrayList<>()).add(num[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (outmap.containsKey(curr)) {
                    ArrayList<Integer> list = outmap.get(curr);
                    for (int num : list) {
                        map.get(num).remove(Integer.valueOf(curr));
                        if (map.containsKey(num) && map.get(num).size() == 0) {
                            q.offer(num);
                            map.remove(num);
                        }
                    }

                }
            }
        }
        if (map.isEmpty())
            return true;

        return false;
    }
}