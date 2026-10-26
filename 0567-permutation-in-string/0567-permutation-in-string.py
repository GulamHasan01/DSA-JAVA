class Solution(object):
    def add(self, lst, key, val):
        for pair in lst:
            if pair[0] == key:
                pair[1] += val
                if pair[1] == 0:
                    lst.remove(pair)
                return
        if val != 0:
            lst.append([key, val])

    def checkInclusion(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        if len(s1) > len(s2):
            return False

        target = list()
        window = list()

        for i in range(len(s1)):
            self.add(target, s1[i], 1)

        for i in range(len(s2)):
            self.add(window, s2[i], 1)
            
            if i >= len(s1):
                self.add(window, s2[i - len(s1)], -1)
            
            if {tuple(p) for p in window} == {tuple(p) for p in target}:
                return True
                
        return False
