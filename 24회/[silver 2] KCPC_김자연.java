import java.util.*;
import java.io.*;

public class Main {
  static class Team implements Comparable<Team> {
    int id;
    int scores[];
    int score;
    int time;
    int submit;
    
    public Team(int id, int k) {
      this.id = id;
      this.scores = new int[k];
      this.score = 0;
      this.time = 10000;
      this.submit = 0;
    }
    
    public void calcScore() {
      for(int s : scores) {
        score += s;
      }
    }
    
    @Override
    public int compareTo(Team o) {
      if(this.score == o.score) {
        if(this.submit == o.submit) {
          return this.time - o.time;
        }
        return this.submit - o.submit;
      }
      return o.score - this.score;
    }
   }
  
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int T = Integer.parseInt(br.readLine());
      
      for(int tc=0;tc<T;tc++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Team teams[] = new Team[n];
        for(int i=0;i<n;i++) {
          teams[i] = new Team(i, k);
        }
        
        for(int o=0;o<m;o++) {
          st = new StringTokenizer(br.readLine());
          int i = Integer.parseInt(st.nextToken())-1; // team id
          int j = Integer.parseInt(st.nextToken())-1; // prob id
          int s = Integer.parseInt(st.nextToken()); // score
          
          teams[i].scores[j] = Math.max(teams[i].scores[j], s);
          teams[i].time = o;
          teams[i].submit++;
        }
        
        for(int i=0;i<n;i++) {
          teams[i].calcScore();
        }
        
        Arrays.sort(teams);
        
        for(int i=0;i<n;i++) {
          if(teams[i].id != t-1) continue;
          System.out.println(i+1);
        }
      }
  }
}
