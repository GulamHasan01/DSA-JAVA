class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }

        int[] queue = new int[numCourses];
        int front = 0, rear = 0;

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue[rear++] = i;
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;

        while (front < rear) {
            int course = queue[front++];
            ans[i++] = course;

            for (int nextCourse : graph.get(course)) {
                if (--indegree[nextCourse] == 0) {
                    queue[rear++] = nextCourse;
                }
            }
        }

        if (i != numCourses) {
            return new int[0];
        }

        return ans;
    }
}