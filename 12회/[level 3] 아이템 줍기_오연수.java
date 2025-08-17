import java.util.*;

/**
외곽 둘레만 이동
bfs 이동
ㄷ자 이동의 경우 | 로 되는것을 방지하기 위해 좌표를 2배해서 결과 값을 다시 나누기2 한다.
*/
class Solution {
    static int[][] road;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        road = new int[101][101]; // 1: 외곽, 0: 디폴트, -1: 내부
        
        for(int[] r : rectangle) {
            r[0] *= 2;
            r[1] *= 2;
            r[2] *= 2;
            r[3] *= 2;
            
            for(int x = r[0]; x <= r[2]; x++) {
                for(int y = r[1]; y <= r[3]; y++) {
                    if (x == r[0] || x == r[2] || y == r[1] || y == r[3]) {
                        if (road[x][y] == -1) // 다른 직사각형의 내부인 경우는 건너 뛰기
                            continue;
                        
                        road[x][y] = 1;
                    } else { // 현 직사각형의 내부라면 다른 기록도 덮어씌우면서 마킹
                      road[x][y] = -1;
                    }
                }
            }
        }
        
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2);
    }
    
    public int bfs(int x, int y, int r, int c) { // (x, y) ~ (r, c)
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[101][101];
        
        q.add(new int[]{x, y, 0});
        visit[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == r && cur[1] == c) {
                return cur[2] / 2;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx <= 0 || nx > 100 || ny <= 0 || ny > 100)
                    continue;
                if (visit[nx][ny] || road[nx][ny] != 1) 
                    continue;
                
                visit[nx][ny] = true;
                q.add(new int[]{nx, ny, cur[2] + 1});
                
            }
        }
        
        return -1;
    }

}
