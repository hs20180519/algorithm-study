import java.util.*;

public class Main {
  static int N,M;
  static int cnt;
  static int answer;
  
  static int dx[] = {0, 0, 1, -1};
  static int dy[] = {1, -1, 0, 0};

  static char map[][];
  static char strMap[] = {'a', 'b', 'c'};

  static List<int[]> indexes;
  
  public static void perm(int depth, char selected[]) {
    if(depth == cnt) {
      check(selected);
      return;
    }
    
    for(char c : strMap) {
      selected[depth] = c;
      perm(depth+1, selected);
    }
  }
  
  public static void check(char selected[]) {
    for(int i=0;i<indexes.size();i++) {
      int index[] = indexes.get(i);
      map[index[0]][index[1]] = selected[i];
    }
    
    boolean visited[][] = new boolean[N][M];
    for(char c : strMap) {
      int[] start = findStartPoint(c);
      if(start == null) continue;
      
      bfs(start[1], start[0], c, visited);
    }
    
    for(int i=0;i<N;i++) {
      for(int j=0;j<M;j++) {
        if(!visited[i][j]) return;
      }
    }
    
    answer++;
    
    return;
  }
  
  public static int[] findStartPoint(char target) {
    for(int i=0;i<N;i++) {
      for(int j=0;j<M;j++) {
        if(map[i][j] == target) return new int[] {i, j};
      }
    }
    
    return null;
  }
  
  public static void bfs(int x, int y, char target, boolean visited[][]) {
    Queue<int[]> q = new LinkedList<>();
    
    q.add(new int[] {y, x});
    visited[y][x] = true;
    
    while(!q.isEmpty()) {
      int[] cur = q.poll();
      y = cur[0];
      x = cur[1];
      
      for(int i=0;i<4;i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        
        if(nx >= M || nx < 0 || ny >= N || ny < 0) continue;
        if(visited[ny][nx] || map[ny][nx] != target) continue;
        
        q.add(new int[] {ny, nx});
        visited[ny][nx] = true;
      }
    }
  }
  
  public static int Solution(String[] abcMap) {
    N = abcMap.length;
    M = abcMap[0].length();
    cnt = 0;
    answer = 0;
    
    map = new char[N][];
    indexes = new ArrayList<>();
    
    for(int i=0;i<N;i++) {
      String str = abcMap[i];
      char[] charArr = str.toCharArray();
      map[i] = charArr;
      for(int j=0;j<M;j++) {
        if(map[i][j] == '?') indexes.add(new int[] {i, j});
      }
    }
    cnt = indexes.size();
    
    perm(0, new char[cnt]);
    
    return answer;
  }
}
