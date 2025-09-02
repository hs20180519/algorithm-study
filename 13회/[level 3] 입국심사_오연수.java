import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long l = 1;
        long r = (long) times[times.length-1] * n;
        long answer = 0;
        
        while(l + 1 < r) {
            long mid = (l + r) / 2;
            
            long value = calc(times, mid);
            if (value >= n) {
                answer = mid;
                r = mid;
            } else {
                l = mid;
            }
        }
        
        return answer;
    }
    
    public long calc(int[] times, long target) {
        long m = 0;
        for(int t : times) {
            m += target / t;
        }
        return m;
    }
}
