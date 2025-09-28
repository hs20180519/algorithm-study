import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int d;
    static int fx[] = {0, 1, 0, -1};
    static int fy[] = {-1, 0, 1, 0};
    static int bx[] = {0, -1, 0, 1};
    static int by[] = {1, 0, -1, 0};
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y, x;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        while(true) {
            if(map[y][x] == 0) { // 청소x
                map[y][x] = -1;
                cnt++;
            }

            boolean flag = false;
            for(int i=0;i<4;i++) {
                int ny = y + fy[i];
                int nx = x + fx[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(map[ny][nx] != 0) continue;
                flag = true;
            }

            if(flag) { // 청소x 있음
                d = d-1 < 0 ? 3 : d-1;
                int nx = x + fx[d];
                int ny = y + fy[d];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(map[ny][nx] != 0) continue;
                y = ny;
                x = nx;
            } else { // 다청소됨
                int nx = x + bx[d];
                int ny = y + by[d];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(map[ny][nx] == 1) break;
                x = nx;
                y = ny;
            }
        }

        System.out.println(cnt);
    }
}
