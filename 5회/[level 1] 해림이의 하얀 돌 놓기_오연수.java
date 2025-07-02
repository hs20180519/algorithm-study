import java.util.*;

public class Solution {
    static int[] dn = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dm = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] answer;
    static String[] map;
    
    public static int[][] solution(String[] board) {
      answer = new int[8][8];
      map = board;
      
      for (int i = 0; i < 8; i++) {
        for(int j = 0; j < 8; j++) {
          char c = board[i].charAt(j);
          
          if (c == '.') {
            answer[i][j] = checkScore(i, j);
          }
        }
      } 
    
      return answer;
    }
    
    // 8방 탐색 시도하며 score 체크
    static int checkScore(int n, int m) {
      int score = 0;
      
      for(int i = 0; i < 8; i++) {
        int nn = n + dn[i];
        int nm = m + dm[i];
        
        score += func(nn, nm, i, 0);
      }
      
      return score;
    }

    // 보드 탐색을 위한 재귀 함수
    // 1 일 경우 score +1 하며 방향대로 탐색
    // 0 일 경우 score 반환하며 탐색 종료
    static int func(int n, int m, int dir, int score) {
      if (!isIn(n, m)) {
        return 0;
      }
      
      if (map[n].charAt(m) == '0') {
        return score;
      }
      
      if (map[n].charAt(m) == '1') {
        return func(n + dn[dir], m + dm[dir], dir, score + 1);
      }
      
      return 0;
    }

    // 보드 안에 들어오는지 여부 반환
    static boolean isIn(int n, int m) {
      return n >= 0 && n < 8 && m >= 0 && m < 8;
    }
}
