import java.io.*;
import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int[] videoLenArr = parseTime(video_len);
        int[] curTime = parseTime(pos);
        int[] opStartArr = parseTime(op_start);
        int[] opEndArr = parseTime(op_end);
        
        if (isInOpeningTime(curTime, opStartArr, opEndArr)) {
            curTime[0] = opEndArr[0];
            curTime[1] = opEndArr[1];
        }
        
        for(int i = 0; i < commands.length; i++) {
            curTime = calcTime(curTime[0], curTime[1], commands[i], videoLenArr);
            
            if (isInOpeningTime(curTime, opStartArr, opEndArr)) {
                curTime[0] = opEndArr[0];
                curTime[1] = opEndArr[1];
            }
        }
        
        String minute = curTime[0] < 10 ? "0" + curTime[0] : curTime[0] + "";
        String second = curTime[1] < 10 ? "0" + curTime[1] : curTime[1] + "";
        
        answer = minute + ":" + second;
        return answer;
    }
    
    // 시간 문자열을 [분, 초] 배열로 파싱
    private int[] parseTime(String timeStr) {
        String[] parts = timeStr.split(":");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }
    
    // 시간 계산 (next/prev 명령어 처리)
    public static int[] calcTime(int minute, int second, String command, int[] videoLen) {
        if (command.equals("next")) { // +10
            if (second > 50) {
                minute++;
                second -= 50;
            } else {
                second += 10;
            }
            
            // 전체길이 체크
            if (minute > videoLen[0] || (minute == videoLen[0] && second > videoLen[1])) {
                minute = videoLen[0];
                second = videoLen[1];
            }
        
        } else { // -10
            if (second < 10) {
                minute--;
                second += 50;
            } else {
                second -= 10;
            }
            
            if (minute < 0) { // reset
                minute = 0;
                second = 0;
            }
        }
        
        int[] arr = new int[2];
        arr[0] = minute;
        arr[1] = second;
        return arr;
    }
    
    private boolean isInOpeningTime(int[] curTime, int[] opStartArr, int[] opEndArr) {
        return (curTime[0] > opStartArr[0] || (curTime[0] == opStartArr[0] && curTime[1] >= opStartArr[1])) && 
            (curTime[0] < opEndArr[0] || (curTime[0] == opEndArr[0] && curTime[1] <= opEndArr[1]));
    }
}
