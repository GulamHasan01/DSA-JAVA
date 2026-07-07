class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long ans=0;
        long digit;
      while(n>0){
        int rem=n%10;
        if(rem!=0){
        sum+=rem;
        ans=ans*10+rem;
        }
        n=n/10;
      }
      long res=0;
      while(ans>0){
        long rem=ans%10;
       res=res*10+rem;
       ans =ans/10;
      }
      res=res*sum;
      return res;
    }
}