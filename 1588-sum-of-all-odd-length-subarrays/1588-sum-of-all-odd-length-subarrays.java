class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
     int sum=0;

        for (int right = 0; right < arr.length; right++) {
         int l=right+1;
         int r=arr.length-right;
         int n=r*l;
         if (n%2!=0) sum+=(arr[right]*((n/2)+1));
         else sum+=(arr[right]*(n/2));

        }
        return sum;
    }
}