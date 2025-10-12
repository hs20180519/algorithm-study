import java.util.*;

class Solution {
    public int solution(String word) {
        String alpha = "AEIOU";
        int[] weight = new int[5];
        
        for (int i = 0; i < 5; i++) {
            weight[i] = (int)((Math.pow(5, 5 - i) - 1) / 4);
        }
        
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            int index = alpha.indexOf(word.charAt(i));
            result += index * weight[i] + 1;
        }
        
        return result;
    }
}
