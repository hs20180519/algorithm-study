class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0, maxH = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = tmp;
            }
            
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }
        
        answer = maxW * maxH;
        return answer;
    }
}
