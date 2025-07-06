import java.util.*;

public class Solution {
  static int N, M, signal[][], phoneR, phoneC, answer[], K;
  static int dr[] = {1,-1,0,0};
  static int dc[] = {0,0,1,-1};
  static Deque<int[]> q;
   public static int[] getStrongestSignals(int[][] map, int[][] wifi, int[][] phones, int k) {
      answer = new int[phones.length];

	    N = map.length;
	    M = map[0].length;
	    K = k;

	    signal = new int[N][M];
	    q = new ArrayDeque<>();

	    for(int[] wf : wifi){
	      int r = wf[0];
	      int c = wf[1];
	      int weight = wf[2];
	      q.add(new int[]{r, c, weight});
	      signal[r][c] = Math.max(signal[r][c], weight);
	    }
	    
	    BFS(map);
	    
	    for(int i=0 ; i < phones.length ; i++){
	      int[] phone = phones[i];
	      answer[i] = signal[phone[0]][phone[1]];
	    }

		  return answer;
	  }
	  
	  public static void BFS(int map[][]){

	    while(!q.isEmpty()){
	      int[] cur = q.poll();
	      
	      for(int d=0 ; d < 4 ; d++){
	        int nr = cur[0] + dr[d];
	        int nc = cur[1] + dc[d];
	        
	        if(!isIn(nr,nc)) continue;
	        
	        int next = cur[2] - 1 - map[nr][nc]*K;
	        if(next <=0 || signal[nr][nc] >= next) continue;
	        signal[nr][nc] = next;

	        q.offer(new int[]{nr, nc, next});
	      }
	      
	      
	    }
	    
	  }
	  
	  public static boolean isIn(int r, int c){
	    return 0 <= r && r < N && 0 <= c && c < M;
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
