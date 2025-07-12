import java.util.*;

public class Main {
    
    public static int makeGroups(int[] students) {
        
        int answer = 0;
        
        int n = students.length;
        int[] prefix = new int[n+1];
        
        // 누적 합 계산
        for(int i=0; i<n; i++){
          prefix[i+1] = prefix[i] + students[i];
        }
        
        for(int i = 0; i < n; i++){
          for(int j = i; j< n; j++){
            int sum = prefix[j+1]-prefix[i];
            if(sum > 0) answer++;
          }
        }
        
        return answer;
    }
}
