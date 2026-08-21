class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        long first = (long) nums[0];
        long second = (long) nums[1];
        int j = 2;
        int len = 2;
        while (j < nums.length) {
            if (first + second == nums[j]) {
                len = Math.max(len, j - start + 1);
            } else
                start = j - 1;
            first = second;
            second = nums[j];
            j++;
        }
        return len;
    }
}