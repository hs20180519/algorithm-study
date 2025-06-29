import java.util.*;

public class Solution {
  
  static char[][] map;
  static int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
  static int dy[] = {1, -1, 0, 0, 1, -1, 1, -1};
  
  public static int simulate(int x, int y, String[] board) {
    int score = 0;
    for(int i=0;i<8;i++) {
      int nx = x;
      int ny = y;
      int cnt = 0;
      
      while(true) {
        nx += dx[i];
        ny += dy[i];
        
        if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8 || board[ny].charAt(nx) == '.') {
          cnt = 0;
          break;
        }
        if(board[ny].charAt(nx) == '0') break;
        
        cnt++;
      }
      score += cnt;
    }
    return score;
  }
  
  public static int[][] solution(String[] board) {
    int answer[][] = new int[8][8];
    
    for(int i=0;i<8;i++) {
      for(int j=0;j<8;j++) {
        if(board[i].charAt(j) != '.') continue;
        answer[i][j] = simulate(j, i, board);
      }
    }
    return answer;
  }
}
