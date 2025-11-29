import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ordered[] = new int[N];
        int origin[] = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
          int x = Integer.parseInt(st.nextToken());
          ordered[i] = x;
          origin[i] = x;
        }
        
        Arrays.sort(ordered);
        
        int idx = 0;
        for(int i : ordered) {
          if(map.containsKey(i)) continue;
          map.put(i, idx++);
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i : origin) {
          sb.append(map.get(i)).append(' ');
        }
        
        System.out.print(sb);
    }
}
