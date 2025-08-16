import java.util.*;

class Solution{
    public int solution(String s){
        int length = s.length();
        Deque<Character> q = new ArrayDeque<>();

        int idx = 0;
        for(int i=0 ; i < length ; i++){
            if(q.isEmpty() || q.peekLast() != s.charAt(i)){
                q.offerLast(s.charAt(i));
            }else{
                q.pollLast();
            }
        }
        
        int answer = q.isEmpty() ? 1 : 0;
        return answer;
    }
}
