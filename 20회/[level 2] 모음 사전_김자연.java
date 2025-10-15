class Solution {
    static char alphabets[] = new char[] {'A', 'E', 'I', 'O', 'U'};
    static int cnt = 0;
    static int answer = 0;
    
    public void dfs(int depth, char[] word, String target) {
        
        if(target.length() == depth) {
            boolean flag = true;
            for(int i=0;i<target.length();i++) {
                if(target.charAt(i) == word[i]) continue;

                flag = false;
                break;
            }
            if(flag) {
                answer = cnt;
                return;
            }
        }
        
        if(depth == 5) {
            return;
        }
        
        for(int i=0;i<5;i++) {
            word[depth] = alphabets[i];
            cnt++;
            dfs(depth+1, word, target);
        }
    }
    public int solution(String word) {
        dfs(0, new char[5], word);
        
        return answer;
    }
}
