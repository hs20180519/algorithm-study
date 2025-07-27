import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    String str;
    int r, c, dep;
    
    public Node(int r, int c, int dep, String str){
        this.r = r;
        this.c = c;
        this.dep = dep;
        this.str = str;
    }
    
    @Override
    public int compareTo(Node o){
        return this.str.compareTo(o.str);
    }
}

class Solution {
    static int[] dr = {0,0,-1,1};//좌우상하
    static int[] dc = {-1,1,0,0};
    static String[] direction = {"l", "r", "u", "d"};
    
    static int N, M;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        
        String answer = "impossible";
        
        return bfs(x-1,y-1,r-1,c-1, k);
    }
    
    public static String bfs(int x, int y, int r, int c, int depth){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(x,y, 0, ""));
        boolean visit[][][] = new boolean[N][M][depth+1];
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.dep == depth){
                if(cur.r == r && cur.c == c) return cur.str;
                else continue;
            }
            
            for(int d = 0 ; d < 4 ; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if(isIn(nr,nc) && !visit[nr][nc][cur.dep+1]){
                    visit[nr][nc][cur.dep+1] = true;
                    q.add(new Node(nr, nc, cur.dep + 1, cur.str + direction[d]));
                } 
            }
        } 
        return "impossible";
    }
    
    public static boolean isIn(int r, int c){
        if(0 <= r && r < N && 0 <= c && c < M) return true;
        return false;
    }
}
