import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        int ppl = 1;
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i=1;i<words.length;i++) {
            String word = words[i];
            ppl = ppl+1 > n ? 1 : ppl+1;
            
            if(set.contains(word) || words[i-1].charAt(words[i-1].length()-1) != word.charAt(0)) return new int[] {ppl, i/n+1};
            
            set.add(word);
        }

        return new int[] {0, 0};
    }
}
