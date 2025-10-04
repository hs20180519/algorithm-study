import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] paper = new int[102][102];
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            paper[x][y]++;
            paper[x+10][y]--;
            paper[x][y+10]--;
            paper[x+10][y+10]++;
        }
        
        for (int i = 0; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                paper[i][j] += paper[i][j-1];
            }
        }
        for (int j = 0; j <= 100; j++) {
            for (int i = 1; i <= 100; i++) {
                paper[i][j] += paper[i-1][j];
            }
        }
        
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] > 0) count++;
            }
        }
        
        System.out.println(count);
    }
}
