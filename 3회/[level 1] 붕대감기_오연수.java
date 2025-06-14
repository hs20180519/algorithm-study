import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int turn = attacks.length;
        int plusHealCnt = 0;
        int j = 0;
        
        for(int time = 1; time <= attacks[turn-1][0]; time++) {
            // 몬스터 공격 여부 확인 - 공격 시간 확인
            if (j < turn && attacks[j][0] == time) {
                answer -= attacks[j][1];
                plusHealCnt = 0;
                j++;
                if (answer <= 0) { // 죽음
                    break;
                }
            } else {
                answer += bandage[1]; // 초당 회복량
                plusHealCnt++;
                
                if (plusHealCnt == bandage[0]) {
                    answer += bandage[2];
                    plusHealCnt = 0;
                }
                
                if (answer >= health){
                    answer = health;    
                }
            }
        }

        return answer <= 0 ? -1 : answer;
    }
}
