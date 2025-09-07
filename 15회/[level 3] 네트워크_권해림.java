import java.util.*;

class Solution {
    static int parent[];
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for(int i=0 ; i < n ; i++){
            parent[i] = i;
        }

        int answer = 0;
        
        for(int i=0 ; i < n ; i++){
            for(int j=1 ; j < n ; j++){
               if(computers[i][j] == 0) continue;
               if(union(i, j)) answer++;
            }
        }

        return n - answer;
    }
    
    private boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) return false;
        parent[rootA] = rootB;

        return true;
    }
    
    private int find(int a){
        int rootA = parent[a];
        if(rootA == a) return rootA;        
        return find(rootA);
    }
}
