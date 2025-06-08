import java.util.*;
/**
제한 시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값
조건을 만족하는 최솟값, 이분탐색 
*/
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int LENGTH = diffs.length;
        
        int left = 1, right =  100_000; 
        while(left <= right){
            int level = (left + right) / 2;
            
            long total = 0;
            for(int i=0 ; i < LENGTH ; i++){
                if(diffs[i] <= level){
                     total += times[i];
                }else{
                    //숙련도 낮음
                    total += times[i] + (diffs[i] - level) * (times[i-1] + times[i]);
                }
                if(total > limit) break; // 시간초과
                
            }

            if(total > limit){ // 숙련도 부족 
                left = level + 1;
            }else{ // 숙련도 충분
                right = level - 1;
            }
        }//end while
        
        answer = left;
        
        
        return answer;
    }
}
