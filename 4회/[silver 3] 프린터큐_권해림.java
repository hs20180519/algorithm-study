import java.io.*;
import java.util.*;

public class Main {
    static Queue<int[]> queue;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 개수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서

            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{priority, i});
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (checkPririty(cur)) { // 중요도 높은 문서가 있는 경우
                    queue.offer(cur);
                } else { // 인쇄
                    count++;
                    if (cur[1] == M) {
                        sb.append(count).append('\n');
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
    
    public static boolean checkPririty(int[] cur){
      for (int[] doc : queue) {
        if (doc[0] > cur[0]) {
            return true;
        }
      }
      return false;
    }
}
