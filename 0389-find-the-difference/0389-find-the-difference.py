class Solution(object):
    def findTheDifference(self, s, t):
        ss=''.join(sorted(s))
        tt=''.join(sorted(t))
        a=''
        l=int(len(ss))
        for i in range(l):
            if tt[i]!=ss[i]:
                return tt[i]
          
        return tt[-1]
       