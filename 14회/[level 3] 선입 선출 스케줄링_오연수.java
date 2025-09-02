import java.util.*;

class Solution {   
    public int solution(int n, int[] cores) {
        // 최적 시간 찾기
        int lo = 0;
        int hi = 10000 * 10000 + 1;
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            
            int value = calc(mid, cores);
            
            if (value <= n-1) { // n-1 작업을 완수하는 시간 찾기
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        int sum = cores.length; // 0시간 째에 모든 코어에 작업 할당하는 수
        for(int i = 0; i < cores.length; i++) {
            sum += lo / cores[i];
        }
        // System.out.println("sum: " + sum); // 예시 기준 2, 1, 0 => sum: 5
        // --- lo 시간까지의 작업

        // 이제 lo + 1 시간에서 할당되는 코어 확인
        for(int i = 0; i < cores.length; i++) {
            if (hi % cores[i] == 0) {
                sum++;
            }
            if (sum == n) {
                return i + 1;
            }
        }
        
        return -1;
    }
    
    public int calc(int time, int[] cores) {
        int value = cores.length;
        
        for(int c : cores) {
            value += time / c;
        }
        
        return value;
    }
}
