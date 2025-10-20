import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        if(N == 0){
            System.out.println(1);
            return;
        }
        
        Integer[] arr = new Integer[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, Collections.reverseOrder());

        if (N == P && arr[N - 1] >= target) {
            System.out.println(-1);
            return;
        }

        int left = 0, right = N-1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            int score = arr[mid];
            
            if(score <= target) right = mid - 1;
            else left = mid + 1;
        }// end while
        
        int answer = left + 1;
        System.out.println(answer <= P ? answer : -1);
    }
}
