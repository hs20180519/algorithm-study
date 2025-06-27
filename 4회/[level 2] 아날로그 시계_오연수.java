import java.io.*;
import java.util.*;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;

        // 초 변환
        int start = 3600 * h1 + 60 * m1 + s1;
        int end = 3600 * h2 + 60 * m2 + s2;

        answer = calculate(end) - calculate(start);
        answer += alarmNow(start) ? 1 : 0;
        
        return answer;
    }

    // 0시 0분 0초 ~ 해당 시간까지 겹치는 횟수 계산
    static int calculate(int time) {
        // 분침 - 초침
        int minAndSec = time * 59 / 3600;
        
        // 시침 - 초침
        int hourAndSec = time * 719 / 43200;
        
        // 12시 체크 (시침, 분침, 초침 모두 겹치는 시간)
        int noon = time >= 43200 ? 2 : 1;
        
        return minAndSec + hourAndSec - noon;
    }

   // 현재 시간이 겹치는지 유무
    static boolean alarmNow(int time) {
        return time * 59 % 3600 == 0 || time * 719 % 43200 == 0;
    }
}
