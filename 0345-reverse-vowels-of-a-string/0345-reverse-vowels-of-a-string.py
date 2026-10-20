class Solution(object):
    def reverseVowels(self, s):
        ans = list(s)
        vow={'A','E','I','O','U','a','e','i','o','u'}
        i=0
        j = len(s) - 1
        while i<j:
            if s[i] in vow:
                if s[j] in vow:
                    ans[i],ans[j]=ans[j],ans[i]
                    i+=1
                    j-=1
                else:
                    j-=1
            else:
                i+=1
        return ''.join(ans)      
        
        