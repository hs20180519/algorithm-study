import java.util.*;

class Solution {
    static char[][] stor;
    static boolean[][] removed;
    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        removed = new boolean[N][M];
        stor = new char[N][M];
        for(int i = 0; i < N; i++) {
            stor[i] = storage[i].toCharArray();
        }
        
        
        for(int i = 0; i < requests.length; i++) {
            String cur = requests[i];
            
            if (cur.length() == 1) {
                // 외곽 컨테이너만
                searchSuburb(cur.charAt(0));
                  
            } else {
                // 모든 컨테이너
                searchAll(cur.charAt(0));
            }
        }
        
        int answer = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!removed[i][j]) answer++;
            }
        }
        return answer;
    }
    
    static void searchSuburb(char c) {
        List<int[]> removeList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (stor[i][j] == c && !removed[i][j] && isSuburb(i, j)) {
                    removeList.add(new int[]{i, j});
                }
            }
        }
        
        for(int[] cur : removeList) {
            removed[cur[0]][cur[1]] = true;
        }
    }
    
    static void searchAll(char c) {
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (stor[i][j] == c && !removed[i][j]) {
                    removed[i][j] = true;
                }
            }
        }
    }

    // bfs 사용 - 외곽에 닿으면 true, 닿지 않고 큐가 비게 되면 false 반환
    static boolean isSuburb(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        
        visit[x][y] = true;
        q.offer(new int[]{x, y});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    return true;
                
                if (removed[nx][ny] && !visit[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
        
        return false;
    }
}
