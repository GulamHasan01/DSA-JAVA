class Solution {
    public int maxProduct(int n) {
      int max=Integer.MIN_VALUE;
      int sec=Integer.MIN_VALUE;
      while(n>0){
        int rem=n%10;
        if(max<rem){
            sec=max;
            max=rem;
        }else if(max>=rem && sec<rem){
            sec=rem;
        }
        n=n/10;
      }
      return max*sec;
    }
}