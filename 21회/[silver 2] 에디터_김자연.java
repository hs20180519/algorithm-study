import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    List<Character> editor = new LinkedList<>();
    for(int i=0;i<str.length();i++) {
      editor.add(str.charAt(i));
    }
    ListIterator<Character> cursor = editor.listIterator(editor.size());
    
    int M = Integer.parseInt(br.readLine());
    for(int i=0;i<M;i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      String cmd = st.nextToken();
      if(cmd.equals("L")) {
        if(cursor.hasPrevious()) cursor.previous();
      } else if(cmd.equals("D")) {
        if(cursor.hasNext()) cursor.next();
      } else if(cmd.equals("B")) {
        if(!cursor.hasPrevious()) continue;
        cursor.previous();
        cursor.remove();
      } else {
        char c = st.nextToken().charAt(0);
        cursor.add(c);
      }
    }
    
    StringBuffer sb = new StringBuffer();
    for(char c : editor) {
      sb.append(c);
    }
    System.out.println(sb.toString());
  }
}
