package Arrays;

//Finding the maximum distance between two indices in the array such that the colors
// at those indices are different, using an efficient linear scan.

public class MaxDistanceDt2House {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1,8,3,8,3}));
        System.out.println(maxDistance(new int[]{1,1,1,6,1,1,1}));
        System.out.println(maxDistance(new int[]{4,4,4,11,4,4,11,4,4,4,4,4}));

    }

    public static int maxDistance(int[] colors) {
        int ans=0;
        int j=colors.length-1;
        for (int i = 0; i <colors.length; i++) {
            if (colors[0]==colors[j]){
                j--;
            }else{
                ans=Math.max(ans,j);
                j--;
            }
            if (colors[i]!=colors[colors.length-1]){
                ans=Math.max(ans, colors.length-i-1);
            }

        }
        return ans;
    }
}
