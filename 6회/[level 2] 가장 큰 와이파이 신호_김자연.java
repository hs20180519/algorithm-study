import java.util.*;

public class Solution {
  static int N, M;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static int[] answer;
  
  static int d[][];
  
  public static void dijkstra(int[][] map, int x, int y, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[2] - o2[2];
      }
    });
    
    pq.add(new int[] {y, x, 0});
    d[y][x] = 0;
    
    while(!pq.isEmpty()) {
      int[] cur = pq.poll();
      x = cur[1];
      y = cur[0];
      int dist = cur[2];
      
      if(d[y][x] > dist) continue;
      
      for(int i=0;i<4;i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        
        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        
        int cost = map[ny][nx] == 0 ? 1 : 1+k;
        
        if(d[ny][nx] > dist + cost) {
          d[ny][nx] = dist+cost;
          pq.add(new int[] {ny, nx, d[ny][nx]});
        }
      }
    }
  }
  
  public static void check(int phone[][], int k, int s) { // s: strength
    for(int p=0;p<phone.length;p++) {
      int x = phone[p][0];
      int y = phone[p][1];
      
      int power = s - d[y][x] < 0 ? 0 : s - d[y][x];
      
      answer[p] = Math.max(answer[p], power);
    }
  }
  
   public static int[] getStrongestSignals(int[][] map, int[][] wifi, int[][] phone, int k) {
	    answer = new int[phone.length];
	    N = map.length;
	    M = map[0].length;
	   
	    for(int w=0;w<wifi.length;w++) {
	      int x = wifi[w][0];
	      int y = wifi[w][1];
	      d = new int[N][M];
	      
	      for(int i=0;i<N;i++) {
	        Arrays.fill(d[i], Integer.MAX_VALUE);
	      }
	      
	      dijkstra(map, x, y, k);
	      check(phone, k, wifi[w][2]);
	    }
	  
		  return answer;
	  }
}
