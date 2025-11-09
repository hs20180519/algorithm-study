import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String target = br.readLine();
        int[] targetAlpha = new int[26];
        
        for(int i = 0; i < target.length(); i++) {
            targetAlpha[target.charAt(i) - 'A']++;
        }
        
        int count = 0;
        
        while(N-- > 1) {
            String word = br.readLine();
            if (isSimilar(target, word, targetAlpha)) {
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    public static boolean isSimilar(String target, String word, int[] targetAlpha) {
        if (Math.abs(target.length() - word.length()) > 1)
            return false;
        
        int[] wordAlpha = new int[26];
        for(int i = 0; i < word.length(); i++) {
            wordAlpha[word.charAt(i) - 'A']++;
        }
        
        int cnt = 0;
        for(int i = 0; i < wordAlpha.length; i++) {
            cnt += (int) Math.abs(targetAlpha[i] - wordAlpha[i]);
        }
        
        return cnt <= 2;
    }
}
