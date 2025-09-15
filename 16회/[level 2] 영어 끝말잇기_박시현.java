import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        // 전체 값 돌면서 끝말잇기 되고있는지 확인
        // - 끝말잇기 정상적으로 x라면 탈락
        // - 끝말잇기 되어도 중복 단어 나오면 탈락
        
        HashSet<String> used = new HashSet<>();
        
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if(used.contains(words[i])) {
                answer[0] = (i % n) + 1; // 탈락자 번호
                answer[1] = (i / n) + 1; // 몇 번째 차례에 탈락하는지
                break;
            }
            
            if(i > 0 && words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            used.add(word);
        }
        
        return answer;
    }
}
