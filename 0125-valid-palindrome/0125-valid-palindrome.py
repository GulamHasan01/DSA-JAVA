class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        str1=""
        for x in s:
            if x.isalpha() or x.isdigit():
                str1=str1+x
        str1=str1.lower()
        i=0
        j=len(str1)-1
        while i<j:
            if str1[i]!=str1[j]:
                return False
            i+=1
            j-=1
        return True