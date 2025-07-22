class Solution {
    public long solution(int[] sequence) {
        
        long maxSum1 = kadane(sequence, 1);
        long maxSum2 = kadane(sequence, -1);
        
        return Math.max(maxSum1, maxSum2);
    }
    
    private long kadane(int[] sequence, int startPulse) {
        long maxSum = 0;
        long curSum = 0;
        int pulse = startPulse;
        
        for(int i = 0; i < sequence.length; i++) {
            
            long value = (long) sequence[i] * pulse;
            
            // 현재 단일 값과 지금까지 더해온 값 중 최대 비교
            curSum = Math.max(value, curSum + value);
            // 전역 최댓값
            maxSum = Math.max(maxSum, curSum);

            pulse *= (-1);
        }
        
        return maxSum;
    }
}
