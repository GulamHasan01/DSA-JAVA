class Solution {
    public int openLock(String[] deadends, String target) {

        HashSet<String> visited = new HashSet<>();

        for (String s : deadends)
            visited.add(s);

        if (visited.contains("0000"))
            return -1;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                String curr = q.poll();

                if (curr.equals(target))
                    return steps;

                char[] arr = curr.toCharArray();

                for (int i = 0; i < 4; i++) {

                    char original = arr[i];

                    // rotate forward
                    arr[i] = (char) ((original - '0' + 1) % 10 + '0');
                    String next = new String(arr);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }

                    // rotate backward
                    arr[i] = (char) ((original - '0' + 9) % 10 + '0');
                    next = new String(arr);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }

                    arr[i] = original;
                }
            }

            steps++;
        }

        return -1;
    }
}