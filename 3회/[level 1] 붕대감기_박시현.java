class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int bandageCnt = 0;
        int curHealth = health;
        
        int atkIdx = 0;
        int attacksEnd = attacks[attacks.length - 1][0];
        
        for(int i = 1; i <= attacksEnd; i++) {
            if(atkIdx < attacks.length && attacks[atkIdx][0] == i) {
                bandageCnt = 0;
                curHealth -= attacks[atkIdx++][1];
                
                if(curHealth <= 0) {
                    return answer = -1;
                }
                answer = curHealth;
            } else {
                curHealth = Math.min(health, curHealth + x);          
                
                if(++bandageCnt == t) {
                    curHealth = Math.min(health, curHealth + y);
                    bandageCnt = 0;
                }
                answer = curHealth;
            }
        }
        
        return answer;
    }
}
