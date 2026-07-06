package BinarySearch;

public class MedainOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;
        int left = 0;
        int right = n;

        while (left <= right) {
            int cutA = left + (right - left) / 2;
            int cutB = (n + m + 1) / 2 - cutA;


            int l1 = (cutA == 0) ? Integer.MIN_VALUE : nums1[cutA - 1];
            int l2 = (cutB == 0) ? Integer.MIN_VALUE : nums2[cutB - 1];
            int r1 = (cutA == n) ? Integer.MAX_VALUE : nums1[cutA];
            int r2 = (cutB == m) ? Integer.MAX_VALUE : nums2[cutB];


            if (l1 <= r2 && l2 <= r1) {

                if ((n + m) % 2 != 0) {
                    return Math.max(l1, l2);
                }

                else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }

            else if (l1 > r2) {
                right = cutA - 1;
            } else {
                left = cutA + 1;
            }
        }
        return 0.0;
    }
}
