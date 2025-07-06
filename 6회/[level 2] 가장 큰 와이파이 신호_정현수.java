import java.util.*;

public class Solution {
  static int[] dx = { -1, 0, 1, 0};
  static int[] dy = { 0, 1, 0, -1};
   public static int[] getStrongestSignals(int[][] map, int[][] wifi, int[][] phone, int k) {
	    int[] answer = new int[phone.length];
	    int n = map.length;
	    int m = map[0].length;
	    int[][] bfsMap = new int[n][m];
	    boolean[][] visited = new boolean[n][m];
	    
	    // 먼저 wifi를 bfs로 퍼뜨리기 (PQ)
	    // phone 위치 확인
	    
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[2]-a[2]);
	    
	    for(int[] w: wifi){
	      int x = w[0];
	      int y = w[1];
	      int sig = w[2];
	      pq.add(new int[]{x, y, sig});
	      bfsMap[x][y] = sig;
	    }
	   
	   while(!pq.isEmpty()){
	     int[] curr = pq.poll();
	     int cx = curr[0];
	     int cy = curr[1];
	     int csig = curr[2];
	     
	     for(int d=0; d<4; d++){
	       int nx = cx+dx[d];
	       int ny = cy+dy[d];
	       int nsig = curr[2];
	       
	       if(isIn(nx, ny, n, m) && !visited[nx][ny]){
	         // 빈공간이면 -1
	         if(map[nx][ny]==0 && nsig-1 >= 0){
	           pq.add(new int[]{nx, ny, nsig-1});
	           bfsMap[nx][ny] = nsig-1;
	           visited[nx][ny] = true;
	         }
	         // 벽이라면 -k-1
	         if(map[nx][ny]==1 && nsig-1 >= 0){
	           pq.add(new int[]{nx, ny, nsig-1-k});
	           bfsMap[nx][ny] = nsig-1-k;
	           visited[nx][ny] = true;
	         }
	       }
	     }
	   }
	   
	   for(int i=0; i<phone.length; i++){
	     int[] c = phone[i];
	     answer[i] = bfsMap[c[0]][c[1]];
	   }
		  return answer;
	  }
	  
	  public static boolean isIn(int x, int y, int n, int m){
	    return 0 <= x && x < n && 0 <= y && y < m; 
	  }
	  

    public static void main(String[] args) {
        List<TestCase> testCases = new ArrayList<>(Arrays.asList(
                new TestCase(
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {0, 0, 0}
                        },
                        new int[][]{
                                {0, 0, 6},
                                {2, 2, 4}
                        },
                        new int[][]{
                                {1, 1},
                                {0, 2},
                                {2, 1}
                        },
                        2,
                        new int[]{2, 4, 3}
                ),
                new TestCase(
                        new int[][]{
                                {0, 1, 0},
                                {0, 1, 0},
                                {0, 0, 0}
                        },
                        new int[][]{
                                {0, 0, 8},
                                {2, 0, 12}
                        },
                        new int[][]{
                                {2, 2}
                        },
                        3,
                        new int[]{10}
                ),
                new TestCase(
                        new int[][]{
                                {0}
                        },
                        new int[][]{
                                {0, 0, 1}
                        },
                        new int[][]{
                                {0, 0}
                        },
                        1,
                        new int[]{1}
                ),
                new TestCase(
                        new int[][]{
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                                {1, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                                {1, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0}
                        },
                        new int[][]{
                                {0, 0, 100},
                                {5, 5, 20}
                        },
                        new int[][]{
                                {9, 9}
                        },
                        2,
                        new int[]{80}
                )
        ));

        int passed = 0;
        for (int i = 0; i < testCases.size(); i++) {
            TestCase tc = testCases.get(i);
            int[] result = getStrongestSignals(tc.map, tc.wifi, tc.phone, tc.k);
            if (Arrays.equals(result, tc.expected)) {
                System.out.println("✅ Test case " + (i + 1) + " passed");
                passed++;
            } else {
                System.out.println("❌ Test case " + (i + 1) + " failed");
                System.out.println("   expected: " + Arrays.toString(tc.expected));
                System.out.println("   but got : " + Arrays.toString(result));
            }
        }
        System.out.println("\n총 " + passed + " / " + testCases.size() + " 케이스 통과");
    }

    static class TestCase {
        int[][] map;
        int[][] wifi;
        int[][] phone;
        int k;
        int[] expected;

        TestCase(int[][] map, int[][] wifi, int[][] phone, int k, int[] expected) {
            this.map = map;
            this.wifi = wifi;
            this.phone = phone;
            this.k = k;
            this.expected = expected;
        }
    }
}
