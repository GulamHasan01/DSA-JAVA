class Solution(object):
    def minMoves2(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        l=len(nums)
        mid=l/2
        pivot=nums[mid]
        count=0
        for x in nums:
            count+=abs(x-pivot)
        return count