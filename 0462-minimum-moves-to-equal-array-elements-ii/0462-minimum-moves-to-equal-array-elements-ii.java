class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int pivot = nums[mid];
        int count = 0;
        for (int num : nums)
            count += Math.abs(num - pivot);
        return count;
    }
}