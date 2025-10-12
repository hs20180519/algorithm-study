import java.util.*;

class Solution {
    int cnt = 0;
    int answer = 0;
    char[] alphas = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        func(0, new ArrayList<Character>(), word);
        return answer;
    }
    
    public boolean func(int depth, List<Character> list, String target) {
        cnt++; // 무조건 카운트
        
        if (target.length() == list.size()) { // 검사
            boolean isSame = true;
            for(int i = 0; i < list.size(); i++) {
                if (list.get(i) != target.charAt(i))
                    isSame = false;
            }
            if (isSame) {
                answer = cnt - 1;
                return true;
            }
        }
        
        if (depth == 5) { // 종료
            return false;
        }
        
        for(int i = 0; i < 5; i++) {
            list.add(alphas[i]);
            if (func(depth+1, list, target)) {
                return true;    
            }
            list.remove(list.size()-1);
        }
        
        return false;
    }
}
