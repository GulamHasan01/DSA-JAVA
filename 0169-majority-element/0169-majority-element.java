class Solution {
public int majorityElement(int[] nums) {
    int major = 0;
    int ans = 0;
    
    for (int num : nums) {
        if (major == 0) {
            ans = num;
        }
        if (num == ans) {
            major++;
        } else {
            major--;
        }
    }
    return ans;
}
}