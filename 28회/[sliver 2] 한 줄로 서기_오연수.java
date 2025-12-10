import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        Deque<Integer> pos = new ArrayDeque<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());    
        }
        
        func(pos, sb);
        System.out.println(sb.toString());
    }
    
    public static void func(Deque<Integer> pos, StringBuilder sb) {
        if (pos.size() == N) {
            for(int n : pos) {
                sb.append(n + 1).append(' ');
            }
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if (isPossible(i, pos)) { 
                pos.add(i);
                func(pos, sb);
                pos.removeLast();
            }
        }
    }
    
    // 현재 pos에 있는 숫자들 중에 나보다 큰 숫자들이 몇 개 있는지 확인 - arr 과 일치하면 넣기 가능
    public static boolean isPossible(int i, Deque<Integer> pos) {
        int cnt = 0;
        for(int n : pos) {
            if (n > i)
                cnt++;
            else if (n == i)
                return false;
        }
        return arr[i] == cnt;
    }
}
