class Solution {
    public int toSec(int h, int m, int s) {
        return 3600 * h + 60 * m + s;
    }
    
    public int count(int s) {
        int hrCnt = s * 719 / 43200;
        int minCnt = s * 59 / 3600;
        
        return s < 43200 ? hrCnt + minCnt - 1 : hrCnt + minCnt - 2;
    }
    
    public boolean checkAt(int s) {
        return s * 59 % 3600 == 0 || s * 719 % 43200 == 0;
    }
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        
        int startSec = toSec(h1, m1, s1);
        int endSec = toSec(h2, m2, s2);
        
        answer = count(endSec) - count(startSec);
        answer += checkAt(startSec) ? 1 : 0;
        
        
        return answer;
    }
}
