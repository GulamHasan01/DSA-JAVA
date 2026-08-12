class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		List<List<String>> ans = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String s = new String(chars);
			map.computeIfAbsent(s, k -> new ArrayList<>()).add(strs[i]);
		}
		for (ArrayList<String> list:map.values()) {
			ans.add(list);
			
		}
		return ans;
	}
}
