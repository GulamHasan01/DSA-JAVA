package Arrays;

import java.util.ArrayList;

public class MinimumDisPair {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{30,29,19,5},new int[]{25,25,25,25,25}));
    }

    public static int maxDistance(int[] nums1, int[] nums2) {

        int maxDistance=0;
        ArrayList<int[]>ans=new ArrayList<>();
        int i =0;
        int j=0;
        while (j< nums2.length && i< nums1.length){
            if (nums1[i]<=nums2[j]){
                maxDistance = Math.max(maxDistance, j - i);
                j++;
            }else i++;
        }

        for (int[] a:ans){
            maxDistance=Math.max(maxDistance,a[1]-a[0]);
        }
        return maxDistance;
}
}
