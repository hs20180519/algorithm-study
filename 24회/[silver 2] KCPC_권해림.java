import java.io.*;
import java.util.*;

class Team implements Comparable<Team>{
        int id, total, score[], count, last;
        public Team(int id, int[] score){
            this.id = id;
            this.score = score;            
        }
        
        public void submit(int question, int s, int last){
            if(score[question] < s){
                total -= score[question];
                score[question] = s;
                total += s;
            }
            count++;
            this.last = last;
        }
        
        @Override
        public int compareTo(Team team){
            if(this.total == team.total){
                if(this.count == team.count){
                    return this.last - team.last;
                }
                return this.count - team.count;
            }
            return team.total - this.total;
        }
    }
    
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 팀의수
            int K = Integer.parseInt(st.nextToken()); // 문제의 수
            int ID = Integer.parseInt(st.nextToken()) - 1;
            int M = Integer.parseInt(st.nextToken());// 로그 엔트리 수 
            
            Team[] teams = new Team[N];
            for(int i=0 ; i < N ; i++){
                teams[i] = new Team(i, new int[K]);
            }
            Team myTeam = teams[ID];
            
            for(int i=0 ; i < M ; i++){
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken()) - 1;
                int q = Integer.parseInt(st.nextToken()) - 1;
                int s = Integer.parseInt(st.nextToken());
                
                Team team = teams[id];
                team.submit(q, s, i);                
            }
            
            Arrays.sort(teams);
            int answer = Arrays.binarySearch(teams, myTeam);
            sb.append(answer+1).append("\n");
        }

        System.out.println(sb);
    }
}
