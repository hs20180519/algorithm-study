import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 짝이 맞으면 제거
            } else {
                stack.push(c); // 아니면 넣기
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
