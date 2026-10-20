class Solution(object):
    def intersection(self, nums1, nums2):
        result = set()
        num1 = set(nums1)
        
        if len(nums1) > len(nums2):
            for i in range(len(nums2)):
                if nums2[i] in num1:
                    result.add(nums2[i])
        else:
            for i in range(len(nums1)):
                if nums1[i] in set(nums2):
                    result.add(nums1[i])
                    
        return list(result)
