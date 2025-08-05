import java.util.*;

class Solution {
    static int N, M, cnt;
    static char map[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    // check if it's reachable or not
    // make reachable pos '0'
    public void makeEdge() {
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];

        // check if '1' or '0' on the edge
        for(int i=0;i<N;i++) {
            if(map[i][0] == '1' || map[i][0] == '0') {
                visited[i][0] = true;
                q.add(new int[] {i, 0});
            }
            if(map[i][M-1] == '1' || map[i][M-1] == '0') {
                visited[i][M-1] = true;
                q.add(new int[] {i, M-1});
            }
        }
        
        for(int j=0;j<M;j++) {
            if(map[0][j] == '1' || map[0][j] == '0') {
                visited[0][j] = true;
                q.add(new int[] {0, j});
            }
            if(map[N-1][j] == '1' || map[N-1][j] == '0') {
                visited[N-1][j] = true;
                q.add(new int[] {N-1, j});
            }
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] != '1' && map[ny][nx] != '0') continue;
                
                visited[ny][nx] = true;
                q.add(new int[] {ny, nx});
            }
        }

        // visited == reachable => '0'
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(visited[i][j]) map[i][j] = '0';
            }
        }
    }
    
    public void removeAll(char target) {
        List<int[]> pos = new ArrayList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] != target) continue;
                
                pos.add(new int[] {i, j});
            }
        }
        
        remove(pos);
        makeEdge();
    }
    
    public void removeEdge(char target) {
        List<int[]> pos = new ArrayList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] != target) continue;
                if(isEdge(i, j)) pos.add(new int[] {i, j});
            }
        }
        
        remove(pos);
        makeEdge();
    }
    
    public boolean isEdge(int y, int x) {
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= M || ny < 0 || ny >= N) return true;
            if(map[ny][nx] == '0') return true;
        }
        
        return false;
    }

    // 일단 make not reachable('1')
    public void remove(List<int[]> posList) {
        for(int[] pos : posList) {
            int y = pos[0];
            int x = pos[1];
            map[y][x] = '1';
        }
        cnt -= posList.size();
    }
    
    public int solution(String[] storage, String[] requests) {
        N = storage.length; // 행
        M = storage[0].length(); // 열
        cnt = N*M;
        
        map = new char[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                map[i][j] = storage[i].charAt(j);
            }
        }
        
        for(int i=0;i<requests.length;i++) {
            char c = requests[i].charAt(0);
            
            if(requests[i].length() == 1) {
                removeEdge(c);
            } else {
                removeAll(c);
            }
        }
        
        return cnt;
    }
}
