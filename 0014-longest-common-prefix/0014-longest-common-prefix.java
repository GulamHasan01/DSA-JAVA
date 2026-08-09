class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String l = strs[0];
        String r = strs[strs.length - 1];

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < l.length(); i++) {
            if (l.charAt(i) == r.charAt(i))
                sb.append(l.charAt(i));
            else
                break;
        }

        return sb.toString();
    }
}