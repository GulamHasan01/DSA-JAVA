class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        start=0
        duplicate=set()
        ans=0
        for i in range(int(len(s))):
            if s[i] not in duplicate:
                duplicate.add(s[i])
                ans=max(ans,i-start+1)
            else:
                while s[i] in duplicate:
                    duplicate.remove(s[start])
                    start+=1
            duplicate.add(s[i])
            ans=max(ans,i-start+1)
        return ans