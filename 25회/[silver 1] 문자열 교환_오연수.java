import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();
        int len = str.length();
        
        int aNum = 0;
        for(int i = 0; i < len; i++) {
            if (arr[i] == 'a')
                aNum++;
        }
        // System.out.println("총 a개수 " + aNum);
        // 초기

        int cnt = 0;
        for(int i = 0; i < aNum; i++) {
            if (arr[i] == 'b')
                cnt++;
        }
        int minCnt = cnt;
        // System.out.println("초기 교환값" + minCnt);
        for(int i = aNum; i < len; i++) {
            if (arr[i] == 'b')
                cnt++;
            if (arr[i-aNum] == 'b')
                cnt--;
            
            minCnt = Math.min(minCnt, cnt);
        }
        
        // 마지막
        for(int i = 0; i < aNum; i++) { 
            // System.out.println(i + " 추가 " + (len-aNum+i) + " 제외");
            if (arr[i] == 'b')
                cnt++;
            if (arr[len-aNum+i] == 'b')
                cnt--;
            minCnt = Math.min(minCnt, cnt);
        }
        
        System.out.println(minCnt);
        
        
    }
}
