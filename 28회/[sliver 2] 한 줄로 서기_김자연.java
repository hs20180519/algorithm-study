import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans[] = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
          int num = Integer.parseInt(st.nextToken());
          int cnt = 0;
          outer: for(int j=0;j<N;j++) {
            if(cnt == num) {
              for(int k=j;k<N;k++) {
                if(ans[k] == 0) {
                  ans[k] = i+1;
                  break outer;
                }
              }
            } else if(ans[j] == 0) cnt++;
          }
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i : ans) sb.append(i).append(' ');
        
        System.out.println(sb);
    }
}
