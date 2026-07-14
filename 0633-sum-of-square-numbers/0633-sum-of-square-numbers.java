class Solution {
    public boolean judgeSquareSum(int c) {
        int val=(int)Math.sqrt(c);
        // System.out.println(val);
        for(int i=0;i<=val;i++){
            //  System.out.println((i*i));
            //  System.out.println(val*val);
            if((i*i)==c-(val*val)) return true;
            else if((i*i)>c-(val*val)){
                val--;
            }
        }
        return false;
    }
}