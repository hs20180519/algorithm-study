import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < N; i++) {
            int rank = 1;
            for(int j = 0; j < N; j++) {
                if (i == j) continue;
                // 키, 몸무게
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) { // 상위 존재
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}
