import java.util.*;

class Solution {
    static Map<String, Integer> window = new HashMap<>();
    
    public boolean check(String[] want, int[] number) {
        for(int j=0;j<want.length;j++) {
            int cnt = window.getOrDefault(want[j], 0);
            if(cnt < number[j]) return false;
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int size = 10;
        
        for(int i=0;i<size;i++) {
            int cnt = window.getOrDefault(discount[i], 0);
            window.put(discount[i], cnt+1);
        }
        
        for(int i=size-1;i<discount.length;i++) {
            if(check(want, number)) answer++;
            if(i+1 >= discount.length) break;
            
            window.put(discount[i-size+1], window.get(discount[i-size+1]) - 1);
            window.put(discount[i+1], window.getOrDefault(discount[i+1], 0) + 1);
        }
        
        return answer;
    }
}
