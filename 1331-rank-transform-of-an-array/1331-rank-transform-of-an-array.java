class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer, Integer> valueToRank = new HashMap<>();

        for (int num : sortedArr) {
            valueToRank.putIfAbsent(num, valueToRank.size() + 1);
        }
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = valueToRank.get(arr[i]);
        }
        
        return arr;
    }
}
