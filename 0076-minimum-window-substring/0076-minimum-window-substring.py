class Solution(object):  
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if not s or not t:
            return ""
        
        dict_t = Counter(t)
        required = len(dict_t)
        
        window_counts = {}
        formed = 0
        ans = (float("inf"), None, None)
        
        l = 0
        for r in range(len(s)):
            char = s[r]
            window_counts[char] = window_counts.get(char, 0) + 1
            
            if char in dict_t and window_counts[char] == dict_t[char]:
                formed += 1
            
            while l <= r and formed == required:
                char = s[l]
                
                if r - l + 1 < ans[0]:
                    ans = (r - l + 1, l, r)
                
                window_counts[char] -= 1
                if char in dict_t and window_counts[char] < dict_t[char]:
                    formed -= 1
                
                l += 1    
        
        return "" if ans[0] == float("inf") else s[ans[1] : ans[2] + 1]
   