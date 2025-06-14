import java.io.*;
import java.util.*;

class Solution {
    static int n, m;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] oilAmount;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visit = new boolean[n][m];
        oilAmount = new int[m];
        
        findOil(land);
        
        for(int i = 0; i < m; i++) {
            answer = Math.max(answer, oilAmount[i]);
        }
        
        return answer;
    }

    // 석유 탐색 - bfs 활용
    private static void findOil(int[][] land) {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j, land);
                }
            }
        }
    }

    // bfs 탐색 중 오일 덩어리의 크기 및 열의 시작과 끝을 기록, 
    // oilAmount 배열에서 해당하는 열에 오일 덩어리의 크기를 더함
    private static void bfs(int i, int j, int[][] land) {
        int cnt = 0, startIdx = j, endIdx = j;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visit[i][j] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            cnt++;
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (visit[nx][ny] || land[nx][ny] == 0)
                    continue;
                
                startIdx = Math.min(startIdx, ny);
                endIdx = Math.max(endIdx, ny);
                
                queue.add(new int[] {nx, ny});
                visit[nx][ny] = true;
            }
        }

        for(int idx = startIdx; idx <= endIdx; idx++) {
            oilAmount[idx] += cnt;
        }
        
    }
}
