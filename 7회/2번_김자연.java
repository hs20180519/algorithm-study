import java.util.*;

public class Main {
  static int N;
  static int answer;
    
    public static int makeGroups(int[] students) {
        
        N = students.length;
        answer = 0;
        
        int prefixSum[] = new int[N+1];
        prefixSum[0] = 0;
        
        for(int i=1;i<=N;i++) {
          prefixSum[i] = prefixSum[i-1] + students[i-1];
        }
        
        for(int s=1;s<=N;s++) { // start
          for(int e=s;e<=N;e++) { // end
            if(prefixSum[e] - prefixSum[s-1] >= 1) {
              answer++;
            }
          }
        }

        return answer;
    }
}
