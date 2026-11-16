class Solution:
    def digitSum(self, s: str, k: int) -> str:
        while len(s) > k:
            i = 0
            j = 0
            ans = list()
            
            while (i + k) <= len(s):
                val = 0
                while j < i + k:
                    val += int(s[j])
                    j += 1
                i = j
                ans.append(str(val))
              
            if i < len(s):
                val = 0
                for x in s[i:]:
                    val += int(x)
                ans.append(str(val))
                
            s = "".join(ans)
            
        return s




        