class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> subarrayCount = new HashMap<>();

        for (int i = 0; i <= n - k; i++) {
            Set<Integer> uniqueInWindow = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                uniqueInWindow.add(nums[j]);
            }
            for (int val : uniqueInWindow) {
                subarrayCount.put(val, subarrayCount.getOrDefault(val, 0) + 1);
            }
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : subarrayCount.entrySet()) {
            if (entry.getValue() == 1) {
                ans = Math.max(ans, entry.getKey());
            }
        }

        return ans;
    }
}