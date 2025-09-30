import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            int value = map.getOrDefault(c, 0);
            if (value <= 1)
                map.remove(c);
            else
                map.put(c, value - 1);
        }
        
        String answer = "";
        for(String key : map.keySet()) {
            answer = key;
        }
        return answer;
    }
}
