class Solution {
    static long a[];
    static long b[];
    
    public long solution(int[] sequence) {
        long answer = 0;
        a = new long[sequence.length];
        b = new long[sequence.length];
        
        int mul = 1;
        
        for(int i=0;i<sequence.length;i++) {
            a[i] = sequence[i] * mul;
            b[i] = sequence[i] * mul * -1;
            
            mul *= -1;
        }
        
        long curSumA = a[0];
        long curSumB = b[0];
        long maxSum = Math.max(a[0], b[0]);
        
        for(int i=1;i<sequence.length;i++) {
            curSumA = Math.max(a[i], curSumA + a[i]);
            curSumB = Math.max(b[i], curSumB + b[i]);
            
            maxSum = Math.max(Math.max(curSumA, curSumB), maxSum);
        }
        
        return maxSum;
    }
}
