import java.util.*;

class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;
        // x 좌표 값에 대해 오름차순으로 정렬
        Arrays.sort(data, (o1, o2)-> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(i, j, data)) {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    private boolean check(int i, int j, int[][] data) {
        if (data[i][0] == data[j][0] || data[i][1] == data[j][1])
            return false;
         
        for(int k = i + 1; k < j; k++) {
            // 두 좌표 내부에 쐐기 있는지 확인 (x와 y 좌표 확인)
            if (data[i][0] < data[k][0] && data[j][0] > data[k][0]
                && Math.min(data[i][1], data[j][1]) < data[k][1]
                && Math.max(data[i][1], data[j][1]) > data[k][1]) {
                return false;
            }
        }
        
        return true;
    }
}
