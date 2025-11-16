import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 연산의 개수
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int cntZero = 0; // 0의 개수
        
        for(int i = 0; i < N; i++) {
            int addNum = Integer.parseInt(br.readLine());
            if(addNum == 0) {
                if(heap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(heap.poll());
                }
            } else {
                heap.add(addNum);
            }
        }
    }
}
