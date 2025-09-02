import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int chance = 0;
        int army = n;
        
        for(int t = 0; t < enemy.length; t++) {
            pq.add(enemy[t]);
            army -= enemy[t];
            
            if (army < 0) {
                while(!pq.isEmpty()) {
                    if (chance == k) break;
                    
                    army += pq.poll();
                    chance++;
                    
                    if (army >= 0) break;
                }
            }
            
            if (army < 0) {
                return t;
            }
        }
        
        return enemy.length;
    }
}
