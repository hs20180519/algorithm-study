import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int score = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());
    
    if(N == 0) {
      System.out.println(1);
      return;
    }
    
    TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++) {
      int s = Integer.parseInt(st.nextToken());
      tm.put(s, tm.getOrDefault(s, 0) + 1);
    }
    
    if(N == P && tm.lastKey() >= score) {
      System.out.println(-1);
      return;
    }
    
    int rank = 1;
    for(int i : tm.keySet()) {
      if(i <= score) break;
      for(int j=0;j<tm.get(i);j++) rank++;
    }
    
    System.out.println(rank);
  }
}
