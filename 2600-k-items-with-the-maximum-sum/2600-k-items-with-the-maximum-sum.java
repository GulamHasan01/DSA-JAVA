class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans=0;
       if (numOnes>k){
           return k;
       } else if (numOnes+numZeros>k) {
           return numOnes;
       }else{
           int s=k-(numOnes+numZeros);
           ans=numOnes-s;
       }
       return ans;
    }
}