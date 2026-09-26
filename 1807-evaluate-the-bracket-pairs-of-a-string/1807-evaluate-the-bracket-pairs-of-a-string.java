class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            String key = list.get(0);
            String value = list.get(1);
            map.put(key, value);
        }

        int start = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                start = i;
                flag = false;
            }
            if (flag) {
                sb.append(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                flag = true;
                String ss = s.substring(start + 1, i);

                if (map.containsKey(ss)) {

                    sb.append(map.get(ss));
                } else {
                    sb.append( "?");
                }
            }
        }
        return sb.toString();
    }
}