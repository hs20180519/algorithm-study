import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    int ppl[][] = new int[n][2]; // w, h
    for(int i=0;i<n;i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      ppl[i][0] = Integer.parseInt(st.nextToken());
      ppl[i][1] = Integer.parseInt(st.nextToken());
    }
    
    StringBuffer sb = new StringBuffer();
    for(int i=0;i<n;i++) {
      int th = ppl[i][1];
      int tw = ppl[i][0];
      
      int cnt = 0;
      for(int j=0;j<n;j++) {
        if(i == j) continue;
        
        int ch = ppl[j][1];
        int cw = ppl[j][0];
        
        if(th < ch && tw < cw) cnt++;
      }
      
      sb.append(cnt+1).append(' ');
    }
    
    System.out.println(sb.toString());
  }
}
