import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] add = new int[N+1];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            add[i+1] = arr[i] + add[i];
        }
        
        int tmp = add[X];
        int maxvalue = tmp;
        int period = 1;
        for(int i = X+1; i <= N; i++) {
            tmp = add[i] - add[i-X];
            
            if (maxvalue == tmp)
                period++;
            else if (maxvalue < tmp) {
                maxvalue = tmp;
                period = 1;
            }
        }
        
        if (maxvalue == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(maxvalue);
        System.out.println(period);
        
    }
}
