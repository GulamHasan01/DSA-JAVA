class Solution {
    public int minimumAverageDifference(int[] nums) {
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        long leftSum = 0;
        long minDiff = Long.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];

            long leftAvg = leftSum / (i + 1);

            long rightAvg = 0;
            if (i != nums.length - 1) {
                rightAvg = (totalSum - leftSum) / (nums.length - i - 1);
            }

            long diff = Math.abs(leftAvg - rightAvg);

            if (diff < minDiff) {
                minDiff = diff;
                ans = i;
            }
        }

        return ans;
    }
}