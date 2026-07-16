class Solution {
    public long gcdSum(int[] nums) {
        int[] gcd = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            
           
            gcd[i] = getGcd(max,nums[i]);
        }

        Arrays.sort(gcd);

       long ans = 0;
        int i = 0;
        int j = gcd.length - 1;
        while (i < j) {
           
            ans += getGcd(gcd[i],gcd[j]);
            i++;
            j--;
        }

        return ans;
    }
    private int getGcd(int a,int b){
        while(b>0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        return a;
    }
}