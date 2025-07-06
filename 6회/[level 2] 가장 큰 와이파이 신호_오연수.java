import java.util.*;

public class Solution {
   static int N, M, K;
   static int[][] signalMap;
   static int[] dx = {-1, 0, 1, 0};
   static int[] dy = {0, 1, 0, -1};
   
   public static int[] getStrongestSignals(int[][] map, int[][] wifi, int[][] phone, int k) {
	    N = map.length;
	    M = map[0].length;
	    K = k;
	    signalMap = new int[N][M];
	    int[] answer = new int[phone.length];
	    
      // wifi 신호 먼저 퍼뜨리면서 signalMap에 신호 기록
	    for (int i = 0; i < wifi.length; i++) {
	      bfs(map, wifi[i]);
	    } 
	    
      // phone 좌표에 대해 각각 신호 확인
	    for (int i = 0; i < phone.length; i++) {
	      answer[i] = signalMap[phone[i][0]][phone[i][1]];
	    }

		  return answer;
	  }
	  
	  // 신호 측정
	  static void bfs(int[][] map, int[] wifi) {
	     Queue<int[]> q = new ArrayDeque<>();
	     q.offer(wifi);
	     signalMap[wifi[0]][wifi[1]] = Math.max(wifi[2], signalMap[wifi[0]][wifi[1]]);
	     
	     while(!q.isEmpty()) {
	       int[] cur = q.poll();
	       
	       for(int dir = 0; dir < 4; dir++) {
	         int nx = cur[0] + dx[dir];
	         int ny = cur[1] + dy[dir];
	         int signal = cur[2];
	         
	         if (nx < 0 || nx >= N || ny < 0 || ny >= M)
	            continue;
	         
	         // 벽 유무에 따른 신호 감소
	         signal = (map[nx][ny] == 1) ? signal - K - 1 : signal - 1;
	         
	         if (signal <= signalMap[nx][ny]) // 기록된 신호보다 작으면 큐X
	            continue;
	         
	         signalMap[nx][ny] = signal;
	         q.offer(new int[] {nx, ny, signalMap[nx][ny]});
	       }
	     }
	  }
}
