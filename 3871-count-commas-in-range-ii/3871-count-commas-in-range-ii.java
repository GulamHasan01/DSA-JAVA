class Solution {
    public long countCommas(long num) {
        long totalCommas = 0;
        
        for (long threshold = 1_000L; threshold <= num; threshold *= 1_000L) {
            totalCommas += (num - threshold + 1);
            
            if (threshold > Long.MAX_VALUE / 1_000L) {
                break;
            }
        }
        
        return totalCommas;
    }
}
