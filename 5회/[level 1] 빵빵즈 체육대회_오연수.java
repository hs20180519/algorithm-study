import java.util.*;

class Node implements Comparable<Node> {
  int idx;
  int goal;
  int recordTime;
  
  public Node(int idx, int goal, int recordTime) {
    this.idx = idx;
    this.goal = goal;
    this.recordTime = recordTime;
  }
  
  @Override
  public int compareTo(Node other) {
    return this.recordTime > other.recordTime ? 1 : -1;
  }
}

public class Solution {
    public static int[] solution(int[][] records) {
        int[] answer = new int[records.length];

        // 우선순위큐 사용
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int i = 0; i < records.length; i++) {
          pq.offer(new Node(i, records[i][0], records[i][1]));
        }
        
        for (int i = 0; i < records.length; i++) {
          Node cur = pq.poll();
          
          answer[cur.idx] = (cur.goal >= i+1) ? 1 : 0;
          
        }
        
        return answer;
    }
}
