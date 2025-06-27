import java.util.*;
import java.io.*;

public class Main {
    static Queue<Node> q;
    
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = null;
      
      int testCase = Integer.parseInt(br.readLine());
      
      for (int tc = 0; tc < testCase; tc++) {
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        q = new LinkedList<>();
        
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens()) {
          q.offer(new Node(idx, Integer.parseInt(st.nextToken())));
          idx++;
        }
        
        // M 번째 문서가 몇 번째로 출력되는지
        int answer = 0;
        
        while(true) {
          Node curNode = q.poll();
          
          if (isMaxLevel(curNode)) {
            answer++;
            if (curNode.idx == M) {
              break;
            }
          } else {
            q.offer(curNode);
          }
        }
        
        System.out.println(answer);
      }
    }
    
    static boolean isMaxLevel(Node curNode) {
      int maxLevel = curNode.level;
      
      for(Node node : q) {
          maxLevel = Math.max(maxLevel, node.level);
      }
      
      return maxLevel == curNode.level;
    }
      
}

class Node {
  int idx;
  int level;
  
  public Node(int idx, int level) {
    this.idx = idx;
    this.level = level;
  }
}
