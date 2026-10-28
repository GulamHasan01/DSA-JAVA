class Solution(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)<1:
            return 0
        total=sum(nums)
        pre=0

        for i in range(len(nums)):
            right=total-pre-nums[i]
            if pre==right:
                return i
            pre+=nums[i]
        return -1