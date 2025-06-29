public class Solution {
  
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public static int[][] solution(String[] board) {
      char[][] map = new char[8][8];
      for(int i=0; i<8; i++){
        map[i] = board[i].toCharArray();
      }
      int[][] answer = new int[8][8];
      
      for(int i=0; i<8; i++){
        for(int j=0; j<8; j++){
          if(map[i][j] == '.'){ // 빈칸일 때만 놓을 수 있음
            // 이 위치에 흰 돌을 넣었을 때 얻을 수 있는 점수 계산
            int num = 0;
      
            for(int d=0; d<8; d++){
              int count = 0;
              
              for(int k=1; k<=8; k++){
                int nx = i+k*dx[d];
                int ny = j+k*dy[d];
                
                if(isIn(nx, ny)){ // 범위 안이라면
                  if(map[nx][ny] == '1'){ // 검은 돌이면
                    count++;
                  }else if(map[nx][ny] == '0'){ // 흰 돌이면
                    num += count;
                    answer[i][j] = num;
                    break;
                  }else{
                    break;
                  }
                }else{
                  break;
                }
              }
              
            }
          }
        }
      }
    
    return answer;
}

  public static boolean isIn(int x, int y){
    return 0<= x && x < 8 && 0 <= y && y < 8;
  }
  
}
