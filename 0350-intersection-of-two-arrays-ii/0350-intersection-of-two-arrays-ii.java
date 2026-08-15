class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        //    HashMap<Integer,Integer>map1=new HashMap<>();
        // HashMap<Integer,Integer>map2=new HashMap<>();
        // for(int num:nums1){
        //     map1.put(num,map1.getOrDefault(num,0)+1);
        // }
        // int count=0;
        // for(int num:nums2){
        //     map2.put(num,map2.getOrDefault(num,0)+1);
        // }
        // ArrayList<Integer>list=new ArrayList<>();
        int[] ans = new int[list.size()];
        i = 0;
        for (int n : list) {
            ans[i++] = n;
        }
        return ans;
    }
}