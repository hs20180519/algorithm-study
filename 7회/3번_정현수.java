import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;
    static boolean[][] visited;
    static char[][] arr;
    static int n, m;
    static List<int[]> questionMarks = new ArrayList<>();
    
    public static void Solution(String[] abcMap) {
      // 백트래킹 + bfs
      
      n = abcMap.length;
      m = abcMap[0].length();
      arr = new char[n][m];
      
      
      for(int i=0; i<n; i++){
        arr[i] = abcMap[i].toCharArray();
      }
      
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(arr[i][j] == '?'){
            questionMarks.add(new int[]{i, j});        
          }
        }
      }
      
      recur(0);

  }
  public static void recur(int depth){
    // if bfs가 성립하지 않으면 return - 백트래킹
    if(!isValid()){
      return;
    }
    
    if(depth == questionMarks.size()){
      answer++;
      return;
    }
    
    int[] xy = questionMarks.get(depth);
    int x = xy[0];
    int y = xy[1];
    

    for(char ch : new char[]{'a','b','c'}){
      arr[x][y] = ch;
      recur(depth+1);
      arr[x][y] = '?';
   }
  }
  
  public static void bfs(int x, int y, char k){

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});
    visited[x][y] = true;
    
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int cx = cur[0];
      int cy = cur[1];
      
      for(int d=0; d<4; d++){
        int nx = cx+dx[d];
        int ny = cy+dy[d];
        
        if(0<=nx && nx < n&& 0<=ny && ny < m && !visited[nx][ny] && arr[nx][ny] == k){
          visited[nx][ny] = true;
          q.add(new int[]{nx, ny});
        }
      }
    }
  }
  
  public static boolean isValid(){
    visited = new boolean[n][m];
    int aVisited = 0;
    int bVisited = 0;
    int cVisited = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(visited[i][j]) continue;
        
        if(arr[i][j] == 'a'){
          bfs(i, j, 'a');
          if(++aVisited > 1) return false;
        }
        if(arr[i][j] == 'b'){
          bfs(i, j, 'b');
          if(++bVisited > 1) return false;
        }
        if(arr[i][j] == 'c'){
          bfs(i, j, 'c');
          if(++cVisited > 1) return false;
        }
      }
    }
    return true;
  }
}
