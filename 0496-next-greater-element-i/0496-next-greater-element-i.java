class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums2[nums2.length - 1], -1);
        int max = nums2[nums2.length - 1];
        for (int i = nums2.length - 2; i >= 0; i--) {
            int cur = nums2[i];
            int next = nums2[i + 1];
            while (next != -1 && next < cur) {
                next = map.get(next);
            }
            map.put(cur, next);
        }

        int[] num = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            num[i] = map.get(nums1[i]);
        }
        return num;
    }
}