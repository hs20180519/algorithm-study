import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> OB = new HashMap<>();
        Map<Integer, Integer> YB = new HashMap<>();
        
        for(int i = 0; i < topping.length; i++) {
            YB.put(topping[i], YB.getOrDefault(topping[i] ,0) + 1);
        }
        
        OB.put(topping[0], 1);
        for(int idx = 0; idx < topping.length; idx++) {
            
            int v = YB.getOrDefault(topping[idx] ,0);
            if (v == 1) {
                YB.remove(topping[idx]);
            } else if (v > 1) {
                YB.put(topping[idx], v-1);
            }
            
            OB.put(topping[idx], OB.getOrDefault(topping[idx] ,0) + 1);
            
            if (OB.size() == YB.size())
                answer++;
            // System.out.println(String.format("OB: %d, YB: %d", OB.size(), YB.size()));
        }
        
        return answer;
    }
}
