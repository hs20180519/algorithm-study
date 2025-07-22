// 사전 순으로 빠른 경로 리턴 - d, l, r, u
// 가지치기를 하지 않으면 시간 초과 발생!
class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] str = {"d", "l", "r", "u"};
    static int[][] map;
    static String answer = "";
    static int N, M, R, C, K;
    static int cnt = 0;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        map = new int[n][m];
        N = n; M = m; R = r; C = c; K = k;

        // 도착할 수 있는 여부를 미리 판별
        if ((Math.abs(x - r) + Math.abs(y - c)) % 2 != k % 2) {
            return "impossible";
        }
        return search(x, y, 0, new StringBuilder()) ? answer : "impossible";
    }
    
    // dfs + backtracking
    private boolean search(int x, int y, int k, StringBuilder sb) {
        if (k == K) {
            if (x == R && y == C) {
                answer = sb.toString();
                return true;
            }
            return false;
        }
        
        // 움직일 수 있는 숫자가 남은 거리보다 적다면 도착 불가능
        int dist = Math.abs(x - R) + Math.abs(y - C);
        if (K - k < dist) return false;
        
        for(int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx <= 0 || nx > N || ny <= 0 || ny > M)
                continue;
            
            sb.append(str[dir]);

            // 하위 탐색에서 찾았다면 그대로 반환
            if (search(nx, ny, k+1, sb)) {
                return true;
            }
            
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
}
