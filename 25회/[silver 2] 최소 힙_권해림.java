import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i < N ; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                sb.append(q.isEmpty() ? 0 : q.poll()).append("\n");
            }else{
                q.offer(x);
            }
        }

        System.out.println(sb);

    }//end main
}
