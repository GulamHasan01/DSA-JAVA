class Solution {
    public int compareVersion(String version1, String version2) {

        int i = 0;
        int start = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (i < version1.length()) {
            if (version1.charAt(i) == '.') {
                list1.add(version1.substring(start, i));
                start = i + 1;
            }
            i++;
        }
        if (start <= version1.length()) {
            list1.add(version1.substring(start));
        }
        start = 0;
        i = 0;
        while (i < version2.length()) {
            if (version2.charAt(i) == '.') {
                list2.add(version2.substring(start, i));
                start = i + 1;
            }
            i++;
        }
        if (start <= version2.length()) {
            list2.add(version2.substring(start));
        }
        int len = 0;
        int invlen = 0;
        if (list1.size() < list2.size()) {
            len = list1.size();
            invlen = list2.size();
            for (int j = 0; j < len; j++) {
                if (Integer.parseInt(list1.get(j)) < Integer.parseInt(list2.get(j)))
                    return -1;
                else if (Integer.parseInt(list1.get(j)) > Integer.parseInt(list2.get(j)))
                    return 1;
            }

            for (int j = len; j < invlen; j++) {
                if ( Integer.parseInt(list2.get(j))!=0)
                    return -1;
            }
        } else {
            len = list2.size();
            invlen = list1.size();
            for (int j = 0; j < len; j++) {
                if (Integer.parseInt(list1.get(j)) < Integer.parseInt(list2.get(j)))
                    return -1;
                else if (Integer.parseInt(list1.get(j)) > Integer.parseInt(list2.get(j)))
                    return 1;
            }
            for (int j = len; j < invlen; j++) {
                if ( Integer.parseInt(list1.get(j))!=0)
                    return 1;
            }
        }

     //   System.out.println(list2);
        return 0;
    }
}