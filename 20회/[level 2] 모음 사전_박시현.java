import java.util.*;

class Solution {
    static char[] basic = {'A', 'E', 'I', 'O', 'U'};
    static List<String> words = new ArrayList<>();
    
    public int solution(String word) {
        dfs("", 0);
        
        int cnt = 0;
        
        while(cnt < words.size()) {
            if(words.get(cnt).equals(word)) break;
            cnt++;
        }
        
        return cnt + 1;
    }
    
    static void dfs(String cur, int depth) {
        if(depth == 5) return;
        
        for(char one : basic) {
            String next = cur + one;
            words.add(next);
            dfs(next, depth + 1);
        }
    }
    
}
