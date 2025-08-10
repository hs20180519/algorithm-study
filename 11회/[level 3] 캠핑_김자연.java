import java.util.*;

class Solution {
    static int answer;
    public void comb(int n, int[][] data, int depth, int start, int[] selected) {
        if(depth == 2) {
            if(trial(selected[0], selected[1], data)) answer++;
            return;
        }
        
        for(int i=start;i<n;i++) {
            selected[depth] = i;
            comb(n, data, depth+1, i+1, selected);
        }
    }
    
    public boolean trial(int s1, int s2, int[][] data) {
        int[] a = data[s1];
        int[] b = data[s2];
        
        int w = Math.abs(a[0] - b[0]);
        int h = Math.abs(a[1] - b[1]);
      
        // 넓이체크
        if(w == 0 || h == 0) return false;
        
        // 쐐기 포함여부
        for(int i=s1+1;i<s2;i++) {
            int x = data[i][0];
            int y = data[i][1];
            
            if((Math.min(a[0], b[0]) < x && x < Math.max(a[0], b[0])) 
               && (Math.min(a[1], b[1]) < y && y < Math.max(a[1], b[1]))) return false;
        }
        
        return true;
    }
    public int solution(int n, int[][] data) {
        answer = 0;
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        
        comb(n, data, 0, 0, new int[2]);
        
    
        return answer;
    }
}
