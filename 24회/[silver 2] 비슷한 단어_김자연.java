import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine());
      
      String target = br.readLine();
      
      int base[] = new int[26];
      for(char c : target.toCharArray()) {
        base[c - 'A']++;
      }
      
      int answer = 0;
      for(int i=0;i<N-1;i++) {
        String str = br.readLine();
        int cur[] = new int[26];
        for(char c : str.toCharArray()) {
          cur[c - 'A']++;
        }
        
        int o = 0, t = 0;
        for(int j=0;j<26;j++) {
          int diff = base[j] - cur[j];
          if(diff < 0) {
            t -= diff;
          } else if(base[j] - cur[j] > 0) {
            o += diff;
          }
        }
        
        if(o > 1 || t > 1) answer++;
      }
      
      System.out.println(N-1-answer);
  }
}
