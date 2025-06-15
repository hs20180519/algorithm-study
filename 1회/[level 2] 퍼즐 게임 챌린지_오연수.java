class Solution {
    static long low, high;
    
    public int solution(int[] diffs, int[] times, long limit) {
        low = 1;
        high = limit;
        
        while(low <= high) {
            long mid = low + (high - low) / 2;
            
            if (isPossible(diffs, times, mid, limit)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    
        return (int) low;
    }
    
    private static boolean isPossible(int[] diffs, int[] times, long level, long limit) {
        long temp = (long) times[0];
        
        for(int i = 1; i < times.length; i++) {
            if (diffs[i] > level) {
                temp += ((long)diffs[i] - level) * ((long)times[i-1] + (long)times[i]);
            }
            temp += times[i];
        }
        
        return limit >= temp;
    }

}
