import java.util.*;

public class Main {
    
    public static int minCalories(int[] calories, int k) {
        int answer = 0;
      
        Arrays.sort(calories);
        for(int i=0;i<k;i++) {
          answer += calories[i];
        }
      
        return answer;
    }
}
