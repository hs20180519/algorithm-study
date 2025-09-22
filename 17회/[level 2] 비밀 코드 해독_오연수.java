import java.util.*;
// 1 ~ n까지 서로 다른 정수 5개 (오름차순 정렬)
class Solution {
    static int answer;
    static int N;
    static int[][] Q;
    static int[] ANS;
    public int solution(int n, int[][] q, int[] ans) {
        List<Integer> numbers = new ArrayList<>();
        answer = 0;
        N = n;
        Q = q;
        ANS = ans;
        comb(1, 0, numbers);
        return answer;
    }
    
    public void comb(int start, int cnt, List<Integer> numbers) {
        if (cnt == 5) {
            if(checkAns(numbers))
                answer++;
            return;
        }
        
        for(int i = start; i <= N; i++) {
            numbers.add(i);
            comb(i+1, cnt+1, numbers);
            numbers.remove(numbers.size()-1);
        }
    }
    
    public boolean checkAns(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        int cnt;
        for(int i = 0; i < Q.length; i++) {
            cnt = 0;
            for(int j = 0; j < 5; j++) {
                if (set.contains(Q[i][j]))
                    cnt++;
            }
            if (cnt != ANS[i]) 
                return false;
        }
        return true;
    }
    
}
