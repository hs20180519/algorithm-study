import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine()); // 팀 개수, 문제 개수, 내 아이디, 로그 수 
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken()); 
            int t = Integer.parseInt(st.nextToken()); 
            int m = Integer.parseInt(st.nextToken()); 
            
            int[][] score = new int[n][k];
            int[] lastSubmit = new int[n];
            int[] totalSubmit = new int[n];
            
            for(int log = 0; log < m; log++) {
                st = new StringTokenizer(br.readLine()); // id, 문제 번호, 획득 점수
                int id = Integer.parseInt(st.nextToken());
                int pb = Integer.parseInt(st.nextToken());
                int sc = Integer.parseInt(st.nextToken());
                
                score[id-1][pb-1] = Math.max(score[id-1][pb-1], sc);
                lastSubmit[id-1] = log;
                totalSubmit[id-1]++;
            }
            
            List<Node> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                int total = 0;
                for(int j = 0; j < k; j++) {
                    total += score[i][j];
                }
                list.add(new Node(i+1, total, totalSubmit[i], lastSubmit[i]));
            }
            list.sort((a, b) -> {
                if (a.score == b.score) {
                    if (a.totalSubmit == b.totalSubmit) {
                        return a.lastSubmit - b.lastSubmit;
                    }
                    return a.totalSubmit - b.totalSubmit;
                }
                return b.score - a.score;
            });
            
            for(int i = 0; i < n; i++) {
                if (list.get(i).teamId == t) {
                    sb.append(i+1).append('\n');
                    break;
                }
            }
            
        }
        System.out.println(sb.toString());
    }
}

class Node {
    int teamId;
    int score;
    int totalSubmit;
    int lastSubmit;
    
    public Node(int teamId, int score, int totalSubmit, int lastSubmit) {
        this.teamId = teamId;
        this.score = score;
        this.totalSubmit = totalSubmit;
        this.lastSubmit = lastSubmit;
    }
}
