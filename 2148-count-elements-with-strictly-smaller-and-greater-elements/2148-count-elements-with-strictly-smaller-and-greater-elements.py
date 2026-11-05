class Solution:
    def countElements(self, nums: list[int]) -> int:
        low=float("inf")
        high=float("-inf")
        for x in nums:
            low=min(low,x)
            high=max(high,x)
        lc=0
        hc=0

        for x in nums:
            if(x==low):
                lc+=1
            elif x==high:
                hc+=1
        return len(nums)-hc-lc
        