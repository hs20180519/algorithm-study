import java.io.*;
import java.util.*;
// 중복 제거 부분,, 지선생 도움 받았어오

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

        // 중복 제거, HashSet에 담기
        Set<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);

        // List 변환 후 정렬
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        // 정렬된 unique 리스트 기반으로 rank 매핑
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            rank.put(list.get(i), i);
        }

        // 원래 배열 순서대로 압축값 출력
        for (int x : arr) {
            sb.append(rank.get(x)).append(" ");
        }

        System.out.print(sb);
    }
}
