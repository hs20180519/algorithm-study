import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char tail = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);

        int[] answer = {0, 0};
        int wordSize = words.length;

        for(int i=1; i < wordSize ; i++){
            String word = words[i];
            if(set.contains(word) || words[i].charAt(0) != tail){
                answer = new int[]{ (i) % n + 1 , (i / n ) + 1 };
                break;
            } 
            set.add(word);
            tail = words[i].charAt(words[i].length() - 1);
        }
        
        return answer;
    }
}
