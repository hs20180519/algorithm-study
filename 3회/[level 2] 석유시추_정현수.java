import java.util.*;
import java.io.*;

class A {
    static int landSize;
    static int landNumber;
    
    A(int landSize, int landNumber){
        A.landSize = landSize;
        A.landNumber = landNumber;
    }
}


class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int solution(int[][] land) {
        A[][] map = new A[land.length][land[0].length];
        boolean[][] visited = new boolean[land.length][land[0].length];
        
        int landNum = 1;
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    List<int[]> arr = bfs(land, map, i, j, visited);
                    System.out.println(Arrays.toString)
                    for(int[] a : arr){
                        System.out.println(arr.size());
                        map[a[0]][a[1]].landNumber = landNum;
                        map[a[0]][a[1]].landSize = arr.size();
                    }
                }
            }
        }
        int f = 0;
        for(int i=0; i<land[0].length; i++){
            Set<A> s = new HashSet<>();
            int answer = 0;
            for(int j=0; j<land.length; j++){
                if(land[j][i] == 1){
                    s.add(map[j][i]);
                }
            }
            for(A a : s){
                answer+=a.landSize;
            }
            f = Math.max(answer, f);
        }

        return f;
    }
    public List<int[]> bfs(int[][] land, A[][] map, int x, int y, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> arr = new ArrayList<>(); // 방문한 위치 배열
        q.add(new int[]{x, y});
        arr.add(new int[]{x,y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            for(int d=0; d<4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if(isIn(nx, ny, land) && land[nx][ny] == 1 && visited[nx][ny] == false){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    arr.add(new int[]{nx,ny});
                }
            }
        }
        return arr;
    }
    public boolean isIn(int x, int y, int[][] land){
        return 0<= x && x<land.length && 0<= y && y < land[0].length;
    }
}
