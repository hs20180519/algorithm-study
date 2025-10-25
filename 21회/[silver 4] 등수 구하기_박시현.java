import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      // 리스트에 있는 점수 개수 = N
      // 새로운 점수 1개
      // 랭킹리스트 길이 = P
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int newScore = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());
      
      List<Integer> scores = new ArrayList<>();
      
      // 만약 N>0일 때 둘째 줄 입력받고 계산, 0이면 1리턴
      if(N > 0) {
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
          scores.add(Integer.parseInt(st.nextToken()));
        } 
      } else {
          System.out.println(1);
          return;
      }
      
      // 랭킹에 추가할 점수 개수(N) 0인 경우
      if(N == 0) {
        System.out.println(1);
        return;
      }
      
      // 랭킹에 들어갈 자리 남은 경우
      if(N < P) {
        // 새 점수 넣고 정렬
        scores.add(newScore);
        scores.sort(Comparator.reverseOrder());
      } else if (N == P && scores.get(P-1) < newScore) {
        // 전체 개수만큼 차있을 때, 새 점수가 이전 점수보다 낮다면 -1반환
        // 이전 점수보다 높다면 갈아끼우기
        // 새 점수 넣고 정렬
        scores.add(newScore);
        scores.sort(Comparator.reverseOrder());
      } else {
        System.out.println(-1);
        return;
      }
      
      int rank = 1;
      for(int i = 0; i < scores.size(); i++) {
        if(scores.get(i) > newScore) {
          rank++;
        } else {
          break;
        }
      }
      
      System.out.println(rank);
  }
}
