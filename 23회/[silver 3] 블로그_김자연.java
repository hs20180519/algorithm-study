import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int X = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      
      int visitor[] = new int[X];
      
      st = new StringTokenizer(br.readLine());
      for(int i=0;i<X;i++) {
        visitor[i] = Integer.parseInt(st.nextToken());
      }
      
      int sum = 0;
      int max = 0;
      int cnt = 1;
      for(int i=0;i<N;i++) {
        sum += visitor[i];
      }
      
      max = sum;
      
      for(int i=N;i<X;i++) {
        sum -= visitor[i-N];
        sum += visitor[i];
        
        if(max < sum) {
          max = sum;
          cnt = 1;
        } else if(max == sum) {
          cnt ++;
        }
      }
      
      if(max == 0) System.out.println("SAD");
      else System.out.println(max + "\n" + cnt);
      
  }
}
