import java.util.*;

public class Main {
    
    public static int minCalories(int[] calories, int k) {
        Arrays.sort(calories);
        
        int answer = 0;
        for (int i = 0; i < k; i++) {
          answer += calories[i];
        } 
        return answer;
    }
}
