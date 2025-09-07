import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int n = topping.length;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for(int i=0 ; i < n ; i++){
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }
        
        int answer = 0;

        for(int i=0 ; i < n ; i++){
            int count = right.getOrDefault(topping[i], 0) - 1;
            if(count <= 0) right.remove(topping[i]);
            else right.put(topping[i], count);

            left.put(topping[i], left.getOrDefault(topping[i], 0) + 1);
            
            if(right.size() == left.size()) answer++;
        }
        
        return answer;
    }
    
}
