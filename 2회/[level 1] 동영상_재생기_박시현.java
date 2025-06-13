import java.io.*;
import java.util.*;

class Solution {

    // 분단위 초로 변환
    public static int convertStringToSecond(String timeStr) {
        String[] parts = timeStr.split(":");
        int mm = Integer.parseInt(parts[0]);
        int ss = Integer.parseInt(parts[1]);
        return mm * 60 + ss;
    }

    // 초단위 "mm:ss"로 변환
    public static String convertSecondToString(int totalSec) {
        int mm = totalSec / 60;
        int ss = totalSec % 60;
        return String.format("%02d:%02d", mm, ss);
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 시간을 Time 객체로 전환
        int videoLenSec = convertStringToSecond(video_len);
        int posSec = convertStringToSecond(pos);
        int opStartSec = convertStringToSecond(op_start);
        int opEndSec = convertStringToSecond(op_end);

        // 현재 시간이 오프닝 시간 사이라면, 오프닝 끝나는 시간으로 이동
        if (opStartSec <= posSec && posSec <= opEndSec) {
            posSec = opEndSec;
        }

        for (String command : commands) {
            int change = 0;
            switch (command) {
                case "prev":
                    change = -10;
                    break;
                case "next":
                    change = +10;
                    break;
            }
            posSec += change;

            // command로 이동후 결과값이 0 미만 | 비디오길이 초과인 경우
            if (posSec < 0) {
                posSec = 0;
            } else if (videoLenSec < posSec) {
                posSec = videoLenSec;
            }
            
            // 이동하고 난 후의 값이 오프닝 시간 사이에 있는 경우
            if (opStartSec <= posSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
        }

        return convertSecondToString(posSec);
    }
}
