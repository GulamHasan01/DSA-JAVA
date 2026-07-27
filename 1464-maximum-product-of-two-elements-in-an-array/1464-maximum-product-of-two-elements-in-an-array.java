class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sec=Integer.MIN_VALUE;
        for(int num:nums){
            if(num>max){
                sec=max;
                max=num;
            }else if(num<=max && num>sec){
                sec=num;
            }
        }
        return (max-1)*(sec-1);
    }
}