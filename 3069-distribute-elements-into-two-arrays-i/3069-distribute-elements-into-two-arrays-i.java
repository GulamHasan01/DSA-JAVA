class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[1]);
        int i = 2;
        int j = 0;
        while (i < nums.length) {
            if (nums[j] > list.get(list.size() - 1)) {
                j++;
                nums[j] = nums[i];
            } else
                list.add(nums[i]);
            i++;
        }
        j++;
        i = 0;
        while (i < list.size()) {
            nums[j++] = list.get(i);
            i++;
        }
        return nums;
    }
}