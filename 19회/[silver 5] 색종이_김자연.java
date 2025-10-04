import java.util.*;
import java.io.*;

public class Main {
  static int map[][];
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      map = new int[100][100];
      int cnt = 0;
      for(int k=0;k<n;k++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        for(int i=a;i<a+10;i++) {
          for(int j=100-b-10;j<100-b;j++) {
            if(map[i][j] == 1) continue;
            map[i][j] = 1;
            cnt++;
          }
        }
      }
      
      System.out.println(cnt);
  }
}
