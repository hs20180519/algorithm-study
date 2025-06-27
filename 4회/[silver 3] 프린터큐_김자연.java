import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int tc=0;tc<t;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<int[]> printer = new LinkedList<>();
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                int priority = Integer.parseInt(st.nextToken());

                pq.add(new int[] {i, priority});
                printer.add(new int[] {i, priority});
            }

            int order = 0;
            while(!printer.isEmpty()) {
                int[] doc = printer.poll();
                if(doc[1] == pq.peek()[1]) { // 중요도가 가장 높은 문서인 경우
                    pq.poll();
                    order++;
                    if(doc[0] == m) break;
                } else if(doc[1] < pq.peek()[1]) { // 중요도가 가장 높지 않은 문서인 경우
                    printer.add(doc);
                }
            }
            System.out.println(order);
        }
    }
}
