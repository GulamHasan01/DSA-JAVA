class Solution {
    public boolean uniformArray(int[] nums1) {
        int minE=Integer.MAX_VALUE;
        int minO=Integer.MAX_VALUE;
        int e=0;
        int o=0;
        for(int num:nums1){
           if(num%2==0){
            e++;
            minE=Math.min(num,minE);
           }else{
            o++;
             minO=Math.min(num,minO);
           }
        }
        if(o==nums1.length || e==nums1.length) return true;
        if(minE>minO){
            return true;
        }else return false;

    }
}