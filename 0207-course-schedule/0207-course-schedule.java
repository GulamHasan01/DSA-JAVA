class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
   
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int[] indegree = new int[numCourses];
        
        for (int[] prereq : prerequisites) {
            graph[prereq[1]].add(prereq[0]);
            indegree[prereq[0]]++;
        }
        
       
        int[] queue = new int[numCourses];
        int front = 0, rear = 0;
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue[rear++] = i;
            }
        }
        
        int completed = 0;
        
        while (front < rear) {
            int course = queue[front++];
            completed++;
            
            for (int nextCourse : graph[course]) {
                if (--indegree[nextCourse] == 0) {
                    queue[rear++] = nextCourse;
                }
            }
        }
        
        return completed == numCourses;
    }
}