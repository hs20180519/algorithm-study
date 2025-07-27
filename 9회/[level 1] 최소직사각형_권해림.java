import java.util.*;

class Solution {
    static int walletWidth = 0, walletHeight = 0;
    public int solution(int[][] sizes) {
        
        
        final int LENGTH = sizes.length;
        for(int i=0 ; i < LENGTH ; i++){
            int a = sizes[i][0];
            int b = sizes[i][1];
    
            //항상 가로를 길게
            int width = Math.max(a, b);
            int height = Math.min(a,b);

            walletWidth = Math.max(width, walletWidth); 
            walletHeight = Math.max(height, walletHeight); 
        }
        
        int answer = 0;
        return walletWidth*walletHeight;
    }
    
}
