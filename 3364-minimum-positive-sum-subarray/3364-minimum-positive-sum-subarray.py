class Solution:
    def minimumSumSubarray(self, nums: List[int], l: int, r: int) -> int:
        min_sum = float('inf')
        n = len(nums)
        
        for i in range(n):
            val = 0
            for j in range(i, n):
                val += nums[j]
                length = j - i + 1
                
                if l <= length <= r and val > 0:
                    min_sum = min(min_sum, val)
                    
        return min_sum if min_sum != float('inf') else -1