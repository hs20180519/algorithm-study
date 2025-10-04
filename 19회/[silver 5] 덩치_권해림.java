import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int group[][] = new int[N][2];
        for(int i=0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            group[i][0] = Integer.parseInt(st.nextToken());
            group[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int answer[] = new int[N];
        for(int i=0 ; i < N ; i++){
            int count = 1;
            int weight = group[i][0];
            int hight = group[i][1];
            
            for(int j=0 ; j < N ; j++){
                if(i==j) continue;
                if(group[j][0] > weight && group[j][1] > hight) count++;
            }
            
            answer[i] = count;
        }

        for(int a : answer) System.out.print(a + " ");

    }// end main
}
