class Solution {
    static int[] dr = {0,-1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int R, C, boxR, boxC;
    public int solution(int n, int w, int num) {
        C = w;
        R = n / w + 1;
        
        int box[][] = new int[R][C];
        int r=R-1, c=0, d=0;
        for(int i=1 ; i <= n ; i++ ){
            if(!isIn(r, c)) {
                r -= dr[d];
                c -= dc[d];
                d = (d + 1) % 4 ;
                r += dr[d];
                c += dc[d];
                d = (d + 1) % 4 ;
            }

            box[r][c] = i;
            if(i == num){
                boxR = r;
                boxC = c;
            }
            
            r += dr[d];
            c += dc[d];
        }
        
        r = boxR;
        c = boxC;
        int answer = 0;
        while(isIn(r,c) && box[r][c] != 0){
            r--;
            answer++;
        }
        
        return answer;
    }
    
    private static boolean isIn(int r, int c){
        return 0 <= r && r < R && 0 <= c && c < C; 
    }
}
