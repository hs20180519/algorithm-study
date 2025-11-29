import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] temp = arr.clone();
        Arrays.sort(temp);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;

        for (int i = 0; i < N; i++) {
            if (!rankMap.containsKey(temp[i])) {
                rankMap.put(temp[i], rank++);
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(rankMap.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}
