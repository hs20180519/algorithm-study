import java.util.*;

public class Solution {
  
    static class Person implements Comparable<Person> {
      int index;
      int expected;
      int score;
      
      public Person(int index, int expected, int score) {
        this.index = index;
        this.expected = expected;
        this.score = score;
      }
      
      @Override
      public int compareTo(Person o1) {
        return this.score - o1.score;
      }
    }
    
    public static int[] solution(int[][] records) {
        int answer[] = new int[records.length];
        
        List<Person> ranks = new ArrayList<>();
        
        for(int i=0;i<records.length;i++) {
          ranks.add(new Person(i, records[i][0], records[i][1]));
        }
        
        Collections.sort(ranks);
        
        for(int i=0;i<ranks.size();i++) {
          Person cur = ranks.get(i);
          answer[cur.index] = i+1 <= cur.expected ? 1 : 0;
        }
        
        return answer;
    }
}
