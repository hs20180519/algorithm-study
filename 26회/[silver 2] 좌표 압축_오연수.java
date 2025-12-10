import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] coord = new int[N];
        Set<Integer> set = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            coord[i] = Integer.parseInt(st.nextToken());
            set.add(coord[i]);
        }
        
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        for(int i = 0; i < N; i++) {
            sb.append(binarySearch(-1, list.size(), coord[i], list)).append(' ');
        }
        System.out.println(sb.toString());
    }
    
    public static int binarySearch(int l, int r, int target, List<Integer> list) {
        int m = -1;
        while(l+1 < r) {
            m = (l + r) / 2;
            
            if (target == list.get(m)) {
                break;
            } else if (target < list.get(m)) {
                r = m;
            } else {
                l = m;
            }
        }
        return m;
    }
}
