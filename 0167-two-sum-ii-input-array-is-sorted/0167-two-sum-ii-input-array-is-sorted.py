class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        ans=list()
        i=0
        j=len(numbers)-1
        while i<j:
            if numbers[i]+numbers[j]==target:
                ans.append(i+1)
                ans.append(j+1)
                return ans
            elif numbers[i]+numbers[j]>target:
                j-=1
            else:
                i+=1
        return ans