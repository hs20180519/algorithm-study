import java.io.*;
import java.util.*;

/**
초침이 시침/분침을 만나는 횟수 계산
**/
class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;

        int start = 3600 * h1 + 60 * m1 + s1;
        int end = 3600 * h2 + 60 * m2 + s2;

        answer = calcAlarmTime(end) - calcAlarmTime(start);
        answer += checkAlarm(start) ? 1 : 0;
        
        return answer;
    }

    /**
    두 바늘이 겹치는 주기는 두 바늘의 상대 속도로 결정
    **/ 
    static int calcAlarmTime(int time) {
        int minAndSec = time * 59 / 3600;        
        int hourAndSec = time * 719 / 43200;
        
        // 시침, 분침, 초침 모두 겹치는 시간
        int noon = time >= 43200 ? 2 : 1;
        
        return minAndSec + hourAndSec - noon;
    }

   // 현재 시간이 겹치는지 유무
    static boolean checkAlarm(int time) {
        return time * 59 % 3600 == 0 || time * 719 % 43200 == 0;
    }
}
