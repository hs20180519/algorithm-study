class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int heigth = 0;
        for(int i = 0; i < sizes.length; i++) {
            int tempW = sizes[i][0];
            int tempH = sizes[i][1];
            
            if(tempW < tempH) {
                int temp = sizes[i][0];
                tempW = tempH;
                tempH = temp;
            }
            
            width = Math.max(width, tempW);
            heigth = Math.max(heigth, tempH);
        }
        
        return width * heigth;
    }
}
