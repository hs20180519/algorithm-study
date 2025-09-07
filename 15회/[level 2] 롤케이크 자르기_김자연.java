import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int me[] = new int[topping.length];
        Set<Integer> tmp = new HashSet<>();
        me[0] = 1;
        tmp.add(topping[0]);
        for(int i=1;i<topping.length;i++) {
            int size = tmp.size();
            tmp.add(topping[i]);
            
            if(size < tmp.size()) me[i] = me[i-1] + 1;
            else me[i] = me[i-1];
        }
        
        tmp.clear();
        int sis[] = new int[topping.length];
        sis[topping.length-1] = 1;
        tmp.add(topping[topping.length-1]);
        
        for(int i=topping.length-2;i>=0;i--) {
            int size = tmp.size();
            tmp.add(topping[i]);
            
            if(size < tmp.size()) sis[i] = sis[i+1]+1;
            else sis[i] = sis[i+1];
        }
        
        int answer = 0;
        for(int i=0;i<topping.length-2;i++) {
            if(me[i] == sis[i+1]) answer++;
        }
        return answer;
    }
}
