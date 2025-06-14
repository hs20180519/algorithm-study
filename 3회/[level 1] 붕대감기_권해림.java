class Solution {
    public int solution(int[] bandage, int maxHealth, int[][] attacks) {
        
        int health = maxHealth, time = 0;
        for(int[] attack : attacks){
            int nextTime = attack[0];

            //연속성공
            int continues = nextTime - 1 - time;
            health = Math.min(maxHealth, health + continues*bandage[1] + continues/bandage[0]*bandage[2]);

            //몬스터 공격
            health -= attack[1];

            if(health <= 0) return -1;
            time = nextTime;
        }
        
        return health;
    }
    
}
