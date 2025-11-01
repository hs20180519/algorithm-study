import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int building[] = new int[N];

        for(int i=0;i<N;i++) {
            building[i] = Integer.parseInt(br.readLine());
        }

        long sum = 0;
        ArrayDeque<long[]> ad = new ArrayDeque<>();
        for(int i=N-1;i>=0;i--) {
            if(ad.isEmpty()) {
                ad.addFirst(new long[] {building[i], 0});
                continue;
            }

            long[] top = ad.peekFirst();
            if(top[0] > building[i]) {
                ad.addFirst(new long[] {building[i], 0});
            } else {
                long cnt = 0;
                while(!ad.isEmpty()) {
                    if(ad.peekFirst()[0] >= building[i]) break;
                    top = ad.poll();
                    cnt += 1 + top[1];
                }
                ad.addFirst(new long[] {building[i], cnt});

                sum += cnt;
            }
        }

        System.out.println(sum);
    }
}
