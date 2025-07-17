import java.util.*;

// 백트래킹 풀이
public class Main {
  static List<int[]> questionCoords = new ArrayList<>();
  
  static char[] charArr = {'a', 'b', 'c'};
  static char[][] map;
  
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  
  static int N, M;
  
  public static int Solution(String[] abcMap) {
    N = abcMap.length;
    M = abcMap[0].length();
    map = new char[N][M];
    
    for (int i = 0; i < abcMap.length; i++) {
      map[i] = abcMap[i].toCharArray();
    }

    // '?' 리스트에 넣기
    questionCoords.clear();
    for(int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == '?') {
          questionCoords.add(new int[] {i, j});
        }
      } 
    }
    
    return backtrack(0);
  }
  
  /**
   * 모든 ?에 대해 채워지면 맵에서 글자들이 연결되어있는지 확인
   */
  static int backtrack(int cnt) {
    if (cnt == questionCoords.size()) {
      return isPossible() ? 1 : 0; 
    }
    
    int totalWays = 0;
    int[] cur = questionCoords.get(cnt);
    int cx = cur[0];
    int cy = cur[1];
    
    for (char c : charArr) {
      map[cx][cy] = c;
      
      if (isPossible()) {
        totalWays += backtrack(cnt + 1);
      }
      
      map[cx][cy] = '?';
    }
    return totalWays;
  }
  
  /**
   * 맵이 유효한 상태인지 확인
   */
  static boolean isPossible() {
    for (char c : charArr) {
      if (!isCharConnected(c)) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * 특정 글자 c 가 연결되어있는지 bfs 통해 탐색
   */
  static boolean isCharConnected(char c) {
    boolean[][] visit = new boolean[N][M];
    int area = 0;
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == c && !visit[i][j]) {
          area++;
          if (area > 1)
            return false;
          bfs(i, j, visit, c);
        }
      } 
    }
    
    return true;
  }
  
  static void bfs(int x, int y, boolean[][] visit, int targetChar) {
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] {x, y});
    visit[x][y] = true;
    
    while(!q.isEmpty()) {
      int[] cur = q.poll();
      
      for (int d = 0; d < 4; d++) {
        int nx = cur[0] + dx[d];
        int ny = cur[1] + dy[d];
        
        if (nx < 0 || nx >= N || ny < 0 || ny >= M)
          continue;
        if (visit[nx][ny] || targetChar != map[nx][ny])
          continue;
          
        visit[nx][ny] = true;
        q.offer(new int[] {nx, ny});
      }
    }
  }
}
