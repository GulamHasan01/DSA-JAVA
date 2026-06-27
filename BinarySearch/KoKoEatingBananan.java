package BinarySearch;

public class KoKoEatingBananan {

    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for (int pile:piles){
            high=Math.max(high,pile);
        }
        while (low<=high){
            int mid=low+(high-low)/2;
            if (isValid(piles,h,mid)){
                high=mid-1;
            }else low=mid+1;
        }
        return low;
    }
    private boolean isValid(int[] arr,int h,int limit){
        long ans=0;
        for (int num:arr){
            ans+=(num+limit-1)/limit;

        }
        return ans <= h;
    }
}
