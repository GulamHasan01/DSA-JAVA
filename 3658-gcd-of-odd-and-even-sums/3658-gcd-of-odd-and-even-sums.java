class Solution {
    public int gcdOfOddEvenSums(int n) {
        int evsum=0,oddsum=0;

        for(int i=1;i<=2*n;i++){
            if(i%2==0) evsum+=i;
            else oddsum+=i;
        }
        int max=0;
        int min=Math.min(evsum,oddsum);
        for(int i=1;i<=min;i++){
      if(evsum%i==0 && oddsum%i==0){
        max=i;
      }
        }
         return max;
    }
}