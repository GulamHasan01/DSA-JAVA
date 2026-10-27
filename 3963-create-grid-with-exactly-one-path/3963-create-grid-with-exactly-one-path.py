class Solution(object):
    def createGrid(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: List[str]
        """
        ans=list()
        for i in range(m):
            if i==0:
                s=""+("."*n)
                ans.append(s)
            else:
                s=""+("#"*(n-1))+"."
                ans.append(s)
        return ans
           
