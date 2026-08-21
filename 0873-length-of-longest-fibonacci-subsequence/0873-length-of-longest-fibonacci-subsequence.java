class Solution {
    public int lenLongestFibSubseq(int[] arr) {
      Set<Integer> set = new HashSet<>();
      int n = arr.length;
        for (int num : arr) {
            set.add(num);
        }
        int Mlen = 0;
          for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int f = arr[i];
                int s = arr[j];
                int len = 2;
            while (set.contains(f + s)) {
                len++;
                int t = f + s;
                f = s;
                s = t;
            }
           if (len > 2) {
                    Mlen=Math.max(len,Mlen);
                }
          
            }
        }
        return Mlen;
    }
}