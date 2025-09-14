import java.util.*;

// n % w : 위치, n / w : 홀수짝수에 따른 왼쪽 오른쪽
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        
        int idx = 0, boxIdx = -1;
        // 1 ~ n 까지
        for(int i = 0; i < n; i++) {
            if ((i / w + 1) % 2 != 0)
                idx = i % w;
            else {
                idx = w-1 - i % w;
            }
            
            if (i == num - 1) { // 박스 위치 갱신
                boxIdx = idx;
            }
                
            if (i >= num && idx == boxIdx) {
                answer++;
            }
        }
        return answer;
    }
}
