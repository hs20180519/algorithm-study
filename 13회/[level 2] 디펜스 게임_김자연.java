import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(enemy.length <= k) return enemy.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int remain = n;
        int round = 0;
        for(int i=0;i<enemy.length;i++) {
            if(pq.size() < k) {
                pq.add(enemy[i]);
                round++;
                continue;
            }
            
            int v = pq.poll();
            if(v < enemy[i]) {
                if(remain < v) break;
                pq.add(enemy[i]);
                remain -= v;
            } else {
                if(remain < enemy[i]) break;
                pq.add(v);
                remain -= enemy[i];
            }
            round++;
        }
        
        return round;
    }
}
