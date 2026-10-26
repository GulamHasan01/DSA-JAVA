class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """
        left=0
        sum=0
        minLen=float('inf') 
        for i in range(len(nums)):
            sum+=nums[i]
            while sum>=target:
                minLen=min(minLen,i-left+1)
                sum-=nums[left]
                left+=1
        return minLen if minLen !=float('inf') else 0
