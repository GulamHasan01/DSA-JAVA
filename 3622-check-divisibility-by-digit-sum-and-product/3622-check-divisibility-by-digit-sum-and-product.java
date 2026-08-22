class Solution {
    public boolean checkDivisibility(int n) {
        int ref=n;
      int sum=0;
      int product=1;
      while(n>0){
        int rem=n%10;
        sum=sum+rem;
        product=product*rem;
        n=n/10;
      }  
      System.out.println(sum+product);
      if(ref%(sum+product)==0)return true;
     return false;
    }
}