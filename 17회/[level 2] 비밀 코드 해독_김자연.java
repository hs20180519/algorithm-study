import java.util.*;

class Solution {
    static int answer;
    public void comb(int start, int depth, int selected[], int n, int[][] q, int[] ans) {
        if(depth == 5) {
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<selected.length;i++) {
                set.add(selected[i]);
            }
            for(int i=0;i<q.length;i++) {
                int cnt = 0;
                for(int j=0;j<5;j++) {
                    if(set.contains(q[i][j])) cnt++;
                }
                if(cnt != ans[i]) return;
            }
            answer++;
            return;
        }
        for(int i=start;i<=n;i++) {
            selected[depth] = i;
            comb(i+1, depth+1, selected, n, q, ans);
        }
    }
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        comb(1, 0, new int[5], n, q, ans);
        return answer;
    }
}
