import java.util.*;

/**
 * 투 포인터 활용
 * (전체) - (0으로만 이루어진 부분 배열 개수) 연산
 */
public class Main {
    static int n;
    static int answer = 0;
    public static int makeGroups(int[] students) {
        n = students.length;
        
        int total = n * (n + 1) / 2; // 전체 부분 배열의 개수
        
        int onlyFresh = 0;
        int left = 0;
        
        while (left < n) {
          if (students[left] == 1) {
            left++;
            continue;
          }
          
          // 0 구간 시작
          int right = left;
          
          while (right < n && students[right] == 0) {
            right++;
          }
          
          // 0 구간 길이
          int zeroLength = right - left;
          // 부분 배열의 개수
          onlyFresh += zeroLength * (zeroLength + 1) / 2;
          
          left = right;
        }
        
        return total - onlyFresh;
    }
}
