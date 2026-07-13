class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flipped = new int[n];
        int flip = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            // Remove the effect of a flip that ended
            if (i >= k) {
                flip ^= flipped[i - k];
            }

            // Current value after considering previous flips
            if ((nums[i] ^ flip) == 0) {

                // Can't flip if there aren't k elements left
                if (i + k > n) {
                    return -1;
                }

                ans++;
                flip ^= 1;
                flipped[i] = 1;
            }
        }

        return ans;
    }
}