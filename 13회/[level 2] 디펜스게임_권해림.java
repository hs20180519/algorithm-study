import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 

        long soldiers = n;
        int usedMujuk = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            soldiers -= enemy[i]; 

            if (soldiers < 0) {
                if (usedMujuk < k) { // 병사 수 부족하면 무적권 사용 
                    int maxEnemy = pq.poll(); 
                    soldiers += maxEnemy;
                    usedMujuk++;
                } else {
                    return i; 
                }
            }
        }
        
        return enemy.length;
    }
}
