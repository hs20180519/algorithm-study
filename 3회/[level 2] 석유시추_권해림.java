import java.util.*;
import java.io.*;
/*
bfs 매번 하지 x
클래스에 가장 왼쪽의 좌표, 가장 오른쪽의 좌표, 사이즈 저장
*/
class Oil{
    int start, end, size;
    
    public Oil(int start, int end, int size){
        this.start = start;
        this.end = end;
        this.size = size;
    }
    
    public int canUse(int c){
        if(start <= c && c <= end) return size;
        return 0;
    }
}


class Solution {
    static int N, M, land[][], map[][], answer = 0;
    static boolean[][] visit;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static List<Oil> oilList = new ArrayList<>();
    public int solution(int[][] land) throws Exception {
        map = land;
        N = land.length;
        M = land[0].length;
        visit = new boolean[N][M];
        //end init
        
        
        //석유 정보 구하기
        for(int i=0 ; i < N ; i++){
            for(int j=0 ; j < M ; j++){
                if(visit[i][j] || map[i][j] == 0) continue;
                BFS(i,j);
            }
        }
        
        getBestOil();
        
        return answer;
    }
    
    public static void getBestOil(){
        for(int i=0 ; i < M ; i++){
            int getOil = 0;
            for(Oil oil : oilList){
                getOil += oil.canUse(i);
            }
            answer = Math.max(answer, getOil);
        }
    }
    
    
    public static void BFS(int r, int c){
        Deque<int[]> q = new ArrayDeque<>();
        visit[r][c] = true;
        q.add(new int[]{r,c});
        
        int count = 0;
        int minC = c;
        int maxC = c;
        
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            count++;
            minC = Math.min(minC, cc);
            maxC = Math.max(maxC, cc);
            
            for(int d=0 ; d < 4 ; d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                if(!isIn(nr,nc) || visit[nr][nc] || map[nr][nc] == 0) continue;
                visit[nr][nc] = true;
                q.add(new int[]{nr,nc});
            }
            
        }//end q while
        
        oilList.add(new Oil(minC, maxC, count));
        
    }//end BFS
    
    
    public static boolean isIn(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
