import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n >= 2) {
            if (n % 2 == 0) {
                    n /= 2;
                    //System.out.println("짝수 " + n);
            } else {
                    n--;
                    ans++;
                    n /= 2;
                    //System.out.println("홀수 " + n);
            }
        }
        ans++; // 1

        return ans;
    }
}
