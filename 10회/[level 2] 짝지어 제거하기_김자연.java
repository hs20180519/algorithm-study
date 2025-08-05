import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> deque = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            if(deque.size() > 0 && deque.peek() == c) {
                deque.pollFirst();
            } else {
                deque.addFirst(c);
            }
        }
        
        int answer = deque.size() > 0 ? 0 : 1;
        return answer;
    }
}
