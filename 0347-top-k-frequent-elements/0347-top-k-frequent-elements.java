class Solution {
    class pair {
        int a;
        int b;

        pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int[] topKFrequent(int[] arr, int k) {
        // Code here
        PriorityQueue<pair> max = new PriorityQueue<>((x, y) -> {
            if (x.b == y.b) {
                return Integer.compare(y.a, x.a);
            }
            return Integer.compare(y.b, x.b);
        });

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            max.add(new pair(key, value));

        }
        int[] num = new int[k];
        for (int i = 0; i < k; i++) {
            pair curr = max.poll();
            num[i] = curr.a;
        }
        return num;
    }
}
