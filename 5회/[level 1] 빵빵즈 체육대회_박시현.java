import java.util.*;

public class Solution {
    public static int[] solution(int[][] records) {
        int[] answer = new int[records.length];
        boolean higher;
        
        // 기존 records 배열 복사
        int[][] compareRecords = new int[records.length][records[0].length];
        for(int i = 0; i < records.length; i++) {
          for(int j = 0; j < records[0].length; j++) {
            compareRecords[i][j] = records[i][j];
          }
        }
        
        // 오름차순 정렬
        Arrays.sort(compareRecords, new Comparator<int[]>() {
          @Override
          public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
          }
        });

        for(int i = 0; i < records.length; i++) {
          int targetRank = records[i][0];
          int score = records[i][1];
          int curScore = compareRecords[targetRank-1][1];
          
          if(score <= curScore) {
            answer[i] = 1;
          }
        };

        return answer;
    }
