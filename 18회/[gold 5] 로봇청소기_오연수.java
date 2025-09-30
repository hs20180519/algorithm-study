import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dc = {0, 1, 0, -1};
    static int[] rotate = {3, 0, 1, 2}; // 반시계
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      int[] start = new int[3];
      for(int i = 0; i < 3; i++) {
        start[i] = Integer.parseInt(st.nextToken());
      }
      
      map = new int[N][M];
      for(int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        
        for(int j = 0; j < M; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      // 청소
      System.out.println(cleanUp(start));
    }
    
    public static int cleanUp(int[] start) {
      int cnt = 0;
      int[] cur = start;
      while(true) {
        // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if (map[cur[0]][cur[1]] == 0) {
          map[cur[0]][cur[1]] = 2; // 마킹
          cnt++;
        }
        // 현재 칸의 주변 4칸 탐색
        int n = 4;
        int dir = cur[2];
        boolean allClean = true;
        while(n-- > 0) { // 현재 방향 기준 (반시계) , 북, 서, 남, 동
          dir = rotate[dir];
          int nr = cur[0] + dr[dir];
          int nc = cur[1] + dc[dir];
          
          if (!isOut(nr, nc) && map[nr][nc] == 0) { // 청소 안된 경우 전진
            cur = new int[] {nr, nc, dir};
            allClean = false;
            break;
          }
        }
        if (!allClean) continue;
        
        // 사방 청소가 다 된 경우
        int op = (cur[2] + 2) % 4;  // 0,2 1,3
        int nr = cur[0] + dr[op];
        int nc = cur[1] + dc[op];
        // 후진 가능
        if (!isOut(nr, nc) && map[nr][nc] != 1) {
          cur = new int[] {nr, nc, cur[2]};
        } else {
          break;
        }
      }
      
      return cnt;
    }
    
    public static boolean isOut(int r, int c) {
      return (r < 0 || r >= N || c < 0 || c >= M);
    }
}
