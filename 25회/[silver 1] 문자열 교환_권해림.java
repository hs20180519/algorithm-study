import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        int totalA = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') totalA++;
        }

        if (totalA == 0) {
            System.out.println(0);
            return;
        }

        String doubled = s + s;

        int windowB = 0;
        for (int i = 0; i < totalA; i++) {// a만 있는 구간 만들기
            if (doubled.charAt(i) == 'b') windowB++;
        }

        int answer = windowB;

        for (int i = 1; i < n; i++) {
            if (doubled.charAt(i - 1) == 'b') windowB--;
            if (doubled.charAt(i + totalA - 1) == 'b') windowB++;

            answer = Math.min(answer, windowB);
        }

        System.out.println(answer);
    }
}
