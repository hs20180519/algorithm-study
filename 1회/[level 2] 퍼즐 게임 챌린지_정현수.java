class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = 0;
        while(left <= right){
            int mid = (left + right)/2;
            
            if(isPossible(mid, diffs, times, limit)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
        
    }
    
    public boolean isPossible(int level, int[] diffs, int[] times, long limit){
        long totalTime = 0;
        for(int i=0; i<diffs.length; i++){
            int time_curr = times[i];
            int time_prev = i>0 ? times[i-1] : 0;
       
            if(diffs[i] <= level) totalTime += time_curr;
            else{
                long d = diffs[i] - level;
                totalTime += (time_curr + time_prev) * d + time_curr;
            }
            
            if(totalTime > limit) return false;
        }
        return true;
    }
}
