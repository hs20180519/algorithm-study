import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 블로그 운영일수
        int X = Integer.parseInt(st.nextToken()); // 연속 일자 범위
        int[] visitors = new int[N]; // 방문객 수
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean noVisitors = true;
        for(int i : visitors) {
            if(i != 0) {
                noVisitors = false;
                break;
            }
        }
        if(noVisitors) {
            System.out.println("SAD");
            return;
        }
        
        // 슬라이딩 윈도우 (창 크기 = X)
        int sum = 0;
        
        // 초기 창
        for(int i = 0; i < X; i++) {
            sum += visitors[i];
        }
        
        int maxSum = sum;
        int cnt = 1;
        
        // 슬라이딩 시작
        for(int i = X; i < N; i++) {
            // 왼쪽 값 빼고 오른쪽 새 값 더하기
            sum += visitors[i] - visitors[i-X];
            
            // if(sum == maxSum) {
                // cnt++;
            // }
            
            // if(sum > maxSum) {
                // maxSum = sum;
            // }
            
            if(sum > maxSum) {
                maxSum = sum;
                cnt = 1;
            } else if(sum == maxSum) {
                cnt++;
            }
        }
        
        System.out.println(maxSum);
        System.out.println(cnt);
    }
}
