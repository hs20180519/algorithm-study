import java.util.*;

class Solution {
    public static long MAX_TIME = 1_000_000_000L;
    public long solution(int n, int[] times) {
        long left = 1;
        long right = MAX_TIME * n;
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0; // 입국 심사한 사람수
            
            for (int t : times) {
                count += mid / t;
                if (count >= n) break; 
            }
            
            if (count >= n) { // n명 입국 심사하기 충분한 시간 
                answer = Math.min(mid, answer);
                right = mid - 1;
            } else { // 시간부족
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
