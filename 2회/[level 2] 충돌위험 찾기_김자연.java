import java.util.*;


class Solution {
    static int r = 100, c = 100;
    static int maxPath;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<int[]>[] paths;
    
    public ArrayList<int[]> bfs(int rn, int x, int y, int destX, int destY) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        Map<String, int[]> parent = new HashMap<>();
        
        q.add(new int[]{y, x});
        visited[y][x] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[1];
            int cy = cur[0];
            
            if(cx == destX && cy == destY) break;
            
            for(int i=0;i<4;i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || nx >= c || ny < 0 || ny >= r) continue;
                if(visited[ny][nx]) continue;
                
                q.add(new int[] {ny, nx});
                visited[ny][nx] = true;
                parent.put(ny + " " + nx, new int[] {cy, cx});
            }
        }
        
        ArrayList<int[]> path = new ArrayList<>();
        
        int step[] = new int[] {destY, destX};
        path.add(new int[] {step[0], step[1]});
        
        while(true) {
            if(!parent.containsKey(step[0] + " " + step[1])) break;
            step = parent.get(step[0] + " " + step[1]);
            path.add(new int[] {step[0], step[1]});
            if(step[1] == x && step[0] == y) break;
        }
        
        Collections.reverse(path);
        
        return path;
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        paths = new ArrayList[routes.length];
        
        for(int i=0;i<routes.length;i++) {
            ArrayList<int[]> fullPath = new ArrayList<>();
            for(int j=0;j<routes[i].length-1;j++) {
                int from = routes[i][j] - 1;
                int to = routes[i][j+1] - 1;

                int startX = points[from][0] - 1;
                int startY = points[from][1] - 1;
                int endX = points[to][0] - 1;
                int endY = points[to][1] - 1;

                List<int[]> segment = bfs(i, startX, startY, endX, endY);
                
                if(j > 0 && !segment.isEmpty()) segment.remove(0);
                
                fullPath.addAll(segment);
            }
            
            
            paths[i] = fullPath;
            maxPath = Math.max(maxPath, fullPath.size());
        }
        
        for(int i=0;i<maxPath;i++) {
            Map<String, Integer> cnt = new HashMap<>();
            for(int j=0;j<routes.length;j++) {
                if(paths[j] == null || paths[j].size() <= i) continue;
                int[] cur = paths[j].get(i);
                String key = cur[0] + " " + cur[1];
                
                cnt.put(key, cnt.getOrDefault(key, 0) + 1);
            }
            
            for(int j : cnt.values()) {
                if(j >= 2) answer++;
            }
        }
        
        return answer;
    }
}

// 어려우네요
