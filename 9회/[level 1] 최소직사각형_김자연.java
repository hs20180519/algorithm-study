class Solution {
    public int solution(int[][] sizes) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        
        for(int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);
            
            max = Math.max(max, w);
            min = Math.max(min, h);
        }
        return min * max;
    }
}
