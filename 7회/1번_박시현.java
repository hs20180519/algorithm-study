import java.util.*;

public class Main {
    
    public static int minCalories(int[] calories, int k) {
        // 배열 오름차순 정렬
        Arrays.sort(calories);
        int rst = 0;
        
        for(int i = 0; i < k; i++) {
          rst += calories[i];
        }
        
        return rst;
    }
}
