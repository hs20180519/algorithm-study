class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1]; // heal per sec
        int y = bandage[2];
        int time = attacks[attacks.length-1][0];
        int monster = 0; // monster cursor
        int skill = 0; // bandage cursor
        int answer = health;
        
        for(int i=1;i<=time;i++) {
            if(i == attacks[monster][0]) { // attack turn
                answer -= attacks[monster][1];
                skill = 0;
                monster ++;
                
                if(answer <= 0) {
                    answer = -1;
                    break;
                }
            } else {
                answer = answer + x > health ? health : answer + x;
                skill ++;
                
                if(skill == t) {
                    answer = answer + x > health ? health : answer + y;
                    skill = 0;
                }
            }
        }
        
        return answer;
    }
}
