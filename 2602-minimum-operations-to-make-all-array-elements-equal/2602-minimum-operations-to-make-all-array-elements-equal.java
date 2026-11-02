class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        
        // Step 1: Sort the array to use binary search and split boundaries
        Arrays.sort(nums);
        
        // Step 2: Create a prefix sum array to get ranges sums in O(1) time
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        List<Long> result = new ArrayList<>();
        
        // Step 3: Process each query efficiently
        for (int x : queries) {
            // Find the insertion index of 'x' in the sorted 'nums' array
            int idx = Arrays.binarySearch(nums, x);
            if (idx < 0) {
                idx = -(idx + 1); // Convert insertion point if element not found
            }
            
            // Operations needed for numbers smaller than or equal to x
            long leftCount = idx;
            long leftSum = prefixSum[idx];
            long leftOps = (leftCount * x) - leftSum;
            
            // Operations needed for numbers greater than x
            long rightCount = n - idx;
            long rightSum = prefixSum[n] - prefixSum[idx];
            long rightOps = rightSum - (rightCount * x);
            
            result.add(leftOps + rightOps);
        }
        
        return result;
    }
}
