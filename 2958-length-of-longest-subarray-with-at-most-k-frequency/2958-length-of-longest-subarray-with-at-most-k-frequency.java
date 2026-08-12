class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 0);
        }

        int max = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.get(nums[i]) > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                left++;
            }

            max = Math.max(max, i - left + 1);

        }

        return max;
    }
}