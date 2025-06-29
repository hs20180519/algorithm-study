import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Print {
        int idx;
        int imp;
        public Print(int idx, int imp) {
            this.idx = idx;
            this.imp = imp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 수
            int M = Integer.parseInt(st.nextToken()); // 찾는 문서의 입력받은 인덱스

            Deque<Print> queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                queue.offerLast(new Print(i, p)); // 인덱스와 그에 해당하는 중요도 큐의 뒤(끝)에 추가
            }

            int printCnt = 0;
            while(!queue.isEmpty()) {
                Print curr = queue.peekFirst();
                boolean higher = false;

                for (Print one :queue) {
                    if (one.imp > curr.imp) {
                        higher = true;
                        break;
                    }
                }

                if (higher) {
                    queue.offerLast(queue.pollFirst());
                } else {
                    Print rst = queue.pollFirst();
                    printCnt++;
                    if (rst.idx == M) {
                        System.out.println(printCnt);
                        break;
                    }
                }
            }
        }
    }
}

