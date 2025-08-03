import java.util.*;

class Solution {
    static int N;
    static char[] arr;
    static Stack<Character> st;
    
    public int solution(String s)
    {
        arr = s.toCharArray();
        N = arr.length;
        
        if (N % 2 != 0) {
            return 0;
        }
    
        st = new Stack<>();
        
        for(int i = 0; i < N; i++) {
            if (st.isEmpty()) {
                st.push(arr[i]);
                continue;
            }
            
            char cur = st.peek();
            
            if (cur != arr[i]) { // 안 같으면
                st.push(arr[i]);
            } else { // 같으면 안 넣음
                st.pop();
            }
        }
        
        return st.isEmpty() ? 1 : 0;
    }
}
