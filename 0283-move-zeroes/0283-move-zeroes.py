class Solution(object):
    def moveZeroes(self, nums):
        if int(len(nums))<2:
            return
        i=0
        j=1
        while j<int(len(nums)):
            if nums[i]==0:
                if nums[j] !=0:
                    a=nums[i]
                    nums[i]=nums[j]
                    nums[j]=a
                    i+=1
                    j+=1
                elif j<int(len(nums)):
                    j+=1
            elif j<int(len(nums)):
                i+=1
                j+=1
        