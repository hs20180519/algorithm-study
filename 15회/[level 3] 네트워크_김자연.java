import java.util.*;

class Solution {
    static int parent[];
    
    public void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        if(ap == bp) return;
        
        if(ap < bp) parent[bp] = ap;
        else parent[ap] = bp;
    }
    
    public int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
  
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i == j || computers[i][j] == 0) continue;
                union(i, j);
            }
        }
        
        Set<Integer> network = new HashSet<>();
        
        for(int i=0;i<n;i++) {
            network.add(find(parent[i]));
        }
        return network.size();
    }
}
