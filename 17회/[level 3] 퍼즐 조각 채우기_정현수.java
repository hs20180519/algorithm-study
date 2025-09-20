import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int n;
    
    public int solution(int[][] game_board, int[][] table) {
        
        n = game_board.length;

        
        // 1. 빈 공간 추출
        List<List<int[]>> blanks = new ArrayList<>();
        boolean[][] visitedBoard = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(game_board[i][j] == 0 && !visitedBoard[i][j]){
                    blanks.add(bfs(i, j, game_board, visitedBoard, 0));
                }
            }
        }
        

        
        // 2. 퍼즐 조각 추출
        List<List<int[]>> puzzles = new ArrayList<>();
        boolean[][] visitedTable = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(table[i][j] == 1 && !visitedTable[i][j]){
                    puzzles.add(bfs(i, j, table, visitedTable, 1));
                }
            }
        }
        
          
        
        // 3. 매칭
        boolean[] used = new boolean[puzzles.size()];
        int answer = 0;
        
        for(List<int[]> blank : blanks){
            for(int i=0; i<puzzles.size(); i++){
                if(used[i]) continue;
                List<int[]> puzzle = puzzles.get(i);
                if(match(blank, puzzle)){
                    answer += blank.size();
                    used[i] = true;
                    break;
                }
            }
        }
       
        return answer;
    }
    
     // BFS로 블록(빈칸 or 퍼즐) 추출
    public List<int[]> bfs(int x, int y, int[][] board, boolean[][] visited, int target){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> cells = new ArrayList<>();
        
        visited[x][y] = true;
        q.add(new int[]{x, y});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            cells.add(cur);
            
            for(int d=0; d<4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && board[nx][ny]==target){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        return normalize(cells);
    }
    
    // 좌표를 (0,0) 기준으로 정규화
    public List<int[]> normalize(List<int[]> cells){
        List<int[]> res = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int[] c : cells){
            minX = Math.min(minX, c[0]);
            minY = Math.min(minY, c[1]);
        }
        for(int[] c : cells){
            res.add(new int[]{c[0]-minX, c[1]-minY});
        }
        res.sort((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        return res;
    }
    
    // 퍼즐과 빈칸 모양이 맞는지 확인
    private boolean match(List<int[]> blank, List<int[]> puzzle){
        if(blank.size() != puzzle.size()) return false;
        
        List<int[]> rotated = new ArrayList<>(puzzle);
        for(int r=0; r<4; r++){ // 4방향 회전 체크
            rotated = rotate(rotated);
            if(equal(blank, rotated)) return true;
        }
        return false;
    }
    
    // 90도 회전 후 normalize
    private List<int[]> rotate(List<int[]> cells){
        List<int[]> res = new ArrayList<>();
        for(int[] c : cells){
            res.add(new int[]{c[1], -c[0]});
        }
        return normalize(res);
    }
    
    // 두 모양이 같은지 확인
    private boolean equal(List<int[]> a, List<int[]> b){
        if(a.size()!=b.size()) return false;
        for(int i=0; i<a.size(); i++){
            if(a.get(i)[0]!=b.get(i)[0] || a.get(i)[1]!=b.get(i)[1]) return false;
        }
        return true;
    }
}
