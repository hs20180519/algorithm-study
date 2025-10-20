import java.io.*;
import java.util.*;

public class Main {
    
    static class Node {
        char c;
        Node nxt;
        Node prev;
        
        Node(char c) {
            this.c = c;
            this.prev = null;
            this.nxt = null;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        
        Node head = new Node('\0');
        Node tail = head;
        for(int i = 0; i < str.length(); i++) {
            Node current = new Node(str.charAt(i));
            current.prev = tail;
            tail.nxt = current;
            tail = current;
        }
        
        Node cursor = new Node('\0');
        tail.nxt = cursor;
        cursor.prev = tail;
        
        int M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            
            if (cmd.equals("L")) {
                if (cursor.prev == head) continue;
                cursor = cursor.prev;
            } else if (cmd.equals("D")) {
                if (cursor.nxt == null) continue;
                cursor = cursor.nxt;
            } else if (cmd.equals("B")) { // 삭제
                if (cursor.prev == head) continue;
                
                Node toremove = cursor.prev;
                toremove.prev.nxt = cursor;
                cursor.prev = toremove.prev;
                
            } else if (cmd.equals("P")) { // 추가
                Node node = new Node(st.nextToken().charAt(0));

                if (cursor.prev == null) {
                    head = node;
                } else {
                    cursor.prev.nxt = node;
                }
                node.prev = cursor.prev;
                node.nxt = cursor;
                cursor.prev = node;
            }
            
        }
        
        Node current = head.nxt;
        while(current != null && current.nxt != null) {
            sb.append(current.c);
            current = current.nxt;
        }
        System.out.println(sb.toString());
    }
    
}
