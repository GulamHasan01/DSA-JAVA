class Solution {

    public int minDeletions(String s) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        for (Map.Entry<Character, Integer> entry : list) {
            int val=entry.getValue();
           while(val>0 && set.contains(val)){
            val--;
            count++;
           }
           set.add(val);
        }
        return count;
    }
}