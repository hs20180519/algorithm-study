import java.util.*;

class Solution {
    static long answer;
  
    public void binarySearch(long start, long end, int[] times, int n) {
        if(start > end) return;
        long mid = (start + end) / 2;
        long cnt = 0;
      
        for(int i=0;i<times.length;i++) {
            cnt += mid / times[i];
            if(cnt >= n) break;
        }
        
        if(cnt >= n) {
            answer = Math.min(answer, mid);
            binarySearch(start, mid-1, times, n);
        }
        else binarySearch(mid+1, end, times, n);
    }
    public long solution(int n, int[] times) {
        long end = (times[times.length-1]*(long)n);
        answer = end;
        
        Arrays.sort(times);
        binarySearch(1, end, times, n);
      
        return answer;
    }
}
