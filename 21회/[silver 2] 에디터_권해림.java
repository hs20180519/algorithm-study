import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (char c : input.toCharArray()) left.push(c);

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            switch (cmd) {
                case 'L':
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty()) left.pop();
                    break;
                case 'P':
                    char c = st.nextToken().charAt(0);
                    left.push(c);
                    break;
            }
        }

        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}
