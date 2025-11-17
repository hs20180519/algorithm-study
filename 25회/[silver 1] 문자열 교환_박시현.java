import java.util.*;
import java.io.*;

// 고정 길이 슬라이딩 윈도우
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine(); // 첫 번째 줄
        int size = 0; // 윈도우 크기(a개수)
        int sum = 0; // 윈도우 내 합계
        char[] toChar = sentence.toCharArray();
        
        // a의 개수만큼으로 윈도우 개수 설정
        for(int i = 0; i < toChar.length; i++) {
            if(sentence.charAt(i) == 'a') {
                size++;
            }
        }
        
        // a없거나 전부 a인 경우
        if(size == 0 || size == toChar.length) {
            System.out.println(0);
            return;
        }
        
        // 문자열 2배 확장 (원형구조, 인덱스 고려)
        String doubled = sentence + sentence;
        
        // 초기 윈도우 내부 b개수
        int bCnt = 0;
        for(int i = 0; i < size; i++) {
            if(doubled.charAt(i) == 'b') bCnt++;
        }
        
        int min = bCnt;
        
        // 윈도우 이동
        for(int i = size; i < size + sentence.length(); i++) {
            
            // 새로 들어오는 문자
            if(doubled.charAt(i) == 'b') bCnt++;
            
            // 빠지는 문자
            int left = i - size;
            if(doubled.charAt(left) == 'b') bCnt--;
            
            // 최소값 갱신
            min = Math.min(bCnt, min);
        }
        
        System.out.println(min);
    }
}
