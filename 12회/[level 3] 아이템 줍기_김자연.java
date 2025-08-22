import java.util.*;

class Solution {
    static int map[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    
    public int bfs(int x, int y, int destX, int destY) {
        Queue<int[]> q = new LinkedList<>();
        int dist[][] = new int[101][101];
        
        int cnt = 1;
        q.add(new int[] {y, x});
        dist[y][x] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[1];
            y = cur[0];
            
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx <= 0 || nx >= 101 || ny <= 0 || ny >= 101) continue;
                if(dist[ny][nx] > 0) continue;
                if(map[ny][nx] != 1) continue;
                
                q.add(new int[] {ny, nx});
                dist[ny][nx] = dist[y][x] + 1;
                
                if(nx == destX && ny == destY) return dist[ny][nx];
            }
        }
        
        return -1;
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        map = new int[101][101];
        
        for(int t=0;t<rectangle.length;t++) {
            int x1 = rectangle[t][0]*2;
            int y1 = rectangle[t][1]*2;
            int x2 = rectangle[t][2]*2;
            int y2 = rectangle[t][3]*2;
            
            for(int i=y1;i<=y2;i++) {
                for(int j=x1;j<=x2;j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        for(int t=0;t<rectangle.length;t++) {
            int x1 = rectangle[t][0]*2;
            int y1 = rectangle[t][1]*2;
            int x2 = rectangle[t][2]*2;
            int y2 = rectangle[t][3]*2;
            
            for(int i=y1+1;i<y2;i++) {
                for(int j=x1+1;j<x2;j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        int answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return answer / 2;
    }
}
