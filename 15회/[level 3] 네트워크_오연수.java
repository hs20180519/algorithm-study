import java.util.*;

// bfs 풀이
class Solution {
    public int solution(int n, int[][] computers) {
        int no = 0;
        int[] visit = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
            if (visit[i] > 0) continue;
            q.clear();

            q.add(i);
            visit[i] = no++;
            
            while(!q.isEmpty()) {
                int cur = q.poll();

                for(int j = 0; j < n; j++) {
                    if (visit[j] > 0 || computers[cur][j] == 0 || j == i) 
                        continue;

                    q.add(j);
                    visit[j] = no;
                }
            }
        }
        // System.out.println(Arrays.toString(visit));
        return no;
    }
}
