import java.util.*;

class Solution {
    static int N;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    
    public List<int[]> bfs(int x, int y, int target, boolean visited[][], int map[][]) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> answer = new ArrayList<>();
        
        q.add(new int[] {y, x});
        answer.add(new int[] {y, x});
        visited[y][x] = true;
        
        while(!q.isEmpty()) {
            int cur[] = q.poll();
            y = cur[0];
            x = cur[1];
            
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] != target) continue;
                
                q.add(new int[] {ny, nx});
                answer.add(new int[] {ny, nx});
                visited[ny][nx] = true;
            }
        }
        return answer;
    }
    
    public List<int[]> normalize(List<int[]> shape) {
        int minRow = N+1;
        int minCol = N+1;
        
        for(int[] pos : shape) {
            minCol = Math.min(minCol, pos[0]);
            minRow = Math.min(minRow, pos[1]);
        }
        
        for(int[] pos : shape) {
            pos[0] -= minCol;
            pos[1] -= minRow;
        }
        
        Collections.sort(shape, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        return shape;
    }
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        N = game_board.length;
        List<List<int[]>[]> shapes = new ArrayList<>();
        List<List<int[]>> holes = new ArrayList<>();
        
        boolean visited[][] = new boolean[N][N];
        
        // 조각추출
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(table[i][j] == 0 || visited[i][j]) continue;
                List<int[]>[] shape = new ArrayList[4];
                shape[0] = normalize(bfs(j, i, 1, visited, table));
                shapes.add(shape);
            }
        }
        
        // 빈공간추출
        visited = new boolean[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(visited[i][j] || game_board[i][j] == 1) continue;
                holes.add(normalize(bfs(j, i, 0, visited, game_board)));
            }
        }
        
        for(List<int[]>[] shape : shapes) {
            for(int i=1;i<4;i++) { // 조각회전
                List<int[]> rotated = new ArrayList<>();
                for(int[] pos : shape[i-1]) { // 좌표회전
                    int x = pos[1];
                    int y = pos[0];
                    
                    int ny = x;
                    int nx = N-y-1;
                    
                    rotated.add(new int[] {ny, nx});
                }
                shape[i] = normalize(rotated);
            }
        }
        
        // 매칭
        boolean used[] = new boolean[shapes.size()];
        outer: for(List<int[]> hole : holes) {
            for(int k=0;k<shapes.size();k++) {
                if(used[k]) continue;
                List<int[]>[] rShapes = shapes.get(k);
                if(rShapes[0].size() != hole.size()) continue;
                
                for(int i=0;i<4;i++) {
                    List<int[]> shape = rShapes[i];
                    
                    boolean flag = true;
                    for(int j=0;j<shape.size();j++) {
                        int rPos[] = shape.get(j);
                        int hPos[] = hole.get(j);
                        if(rPos[0] != hPos[0] || rPos[1] != hPos[1]) {
                            flag = false;
                            break;
                        }
                    }
                    
                    if(flag) {
                        answer += shape.size();
                        used[k] = true;
                        continue outer;
                    }
                }
            }
        }
        return answer;
    }
}
