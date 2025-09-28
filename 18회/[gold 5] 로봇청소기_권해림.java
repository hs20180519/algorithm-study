import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0}; //북동남서
    static int[] dc = {0, 1, 0, -1};
    static int N, M, map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int count = 0;
        while(true){
            //현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if(map[r][c] == 0){
                map[r][c] = 2;
                count++;
            }

            int nextDir = canClean(r, c, d);
            if(nextDir >= 0){//현재 주변 청소되지 않은 빈 칸이 있는 경우
                //반시계 방향으로 회전 후 한 칸 전진
                d = nextDir; 
                r = r + dr[d];
                c = c + dc[d];
            }else{//현재 주변 청소되지 않은 빈 칸이 없는 경우
                //후진할 수 있으면 후진
                int nr = r - dr[d];
                int nc = c - dc[d];
                
                if(!isIn(nr, nc) || map[nr][nc] == 1) break;// 벽이면 종료
                
                r = nr;
                c = nc;
            }
            
        }//end while
        
        System.out.println(count);
        
    }// end main
    
    static int canClean(int r, int c, int dir){  
        int d = dir;
        for(int i=0; i < 4; i++){
            d = (d + 3) % 4;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isIn(nr, nc) && map[nr][nc] == 0) return d;
        }
        return -1;
    }

    
    static boolean isIn(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
