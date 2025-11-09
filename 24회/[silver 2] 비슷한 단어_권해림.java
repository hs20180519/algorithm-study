import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String standard = br.readLine();
        int[] base = new int[26];
        for (char c : standard.toCharArray()) {
            base[c - 'A']++;
        }

        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            String word = br.readLine();
            int[] temp = new int[26];
            for (char c : word.toCharArray()) {
                temp[c - 'A']++;
            }

            int diff = 0;
            for (int j = 0; j < 26; j++) {
                diff += Math.abs(base[j] - temp[j]);
            }

            if (diff <= 2 && Math.abs(standard.length() - word.length()) <= 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
