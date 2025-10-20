import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int taesu = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        if (N == 0) {
            System.out.println(1);
            return;
        }
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i = 0; i < N / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[N-i-1];
            arr[N-i-1] = tmp;
        }

        int idx = 0;
        for(; idx < N; idx++) {
            if (arr[idx] < taesu)
                break;
        }
        
        if (idx >= P) {
            System.out.println(-1);
            return;
        }
        
        int sidx = idx-1;
        int cnt = 0;
        while(sidx >= 0) {
            if (arr[sidx] == taesu) {
                cnt++;
            }else {
                break;
            }
            sidx--;
        }
        int answer = 0;
        if (cnt > 0) {
            answer = idx - cnt + 1;
        } else {
            answer = idx + 1;
        }
        System.out.println(answer);
    }
}
