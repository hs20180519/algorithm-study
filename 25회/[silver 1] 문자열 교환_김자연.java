import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = br.readLine();
      
      int W = 0;
      for(char c : str.toCharArray()) {
        if(c == 'a') W ++;
      }
      
      int cnt = 0;
      for(int i=0;i<W;i++) {
        if(str.charAt(i) == 'b') cnt++;
      }
      
      int min = cnt;
      for(int i=1;i<str.length();i++) {
        int back = i+W-1 >= str.length() ? i+W-str.length()-1 : i+W-1;
        
        if(str.charAt(i-1) == 'b') cnt--;
        if(str.charAt(back) == 'b') cnt++;
        
        min = Math.min(cnt, min);
      }
      
      System.out.println(min);
  }
}
