import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> ss = new HashSet<>();
        ss.add(words[0]);
        int[] answer = null;
        
        for(int i = 1; i < words.length; i++) {
            // 이전에 말한 단어인지 체크
            if (ss.contains(words[i])) {
                answer = checkLoserAndTurn(i, n);
                break;    
            }
            
            // 이전 마지막 글자와 비교
            char lastChar = words[i-1].charAt(words[i-1].length()-1);
            if (lastChar != words[i].charAt(0)) {
                answer = checkLoserAndTurn(i, n);
                break;
            }
            
            ss.add(words[i]);
        }

        return answer == null ? new int[] {0, 0} : answer;
    }
    
    private static int[] checkLoserAndTurn(int idx, int people) {
        int loserNum = idx % people + 1;
        int turn = idx / people + 1;
        return new int[] {loserNum, turn};
    }
}
