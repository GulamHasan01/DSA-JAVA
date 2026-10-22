class Solution(object):
    def hammingWeight(self, n):
        count=0
        while n>0:
            a=n%2
            n=n/2
            if a==1:
                count=count+1
        return count
        