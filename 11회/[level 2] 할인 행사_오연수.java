import java.util.*;

class Solution {
    static int len;

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        len = want.length;
        Map<String, Integer> map = new HashMap<>();
        // 초기
        for(int i = 0; i < 10; i++) {
            int tmp = map.getOrDefault(discount[i], 0);
            map.put(discount[i], tmp + 1);
        }
        if (checkDiscount(map, want, number))
            answer++;
        
        // 진행
        for(int i = 10; i < discount.length; i++) {
            int tmp = map.getOrDefault(discount[i], 0);
            map.put(discount[i], tmp + 1);
            
            tmp = map.getOrDefault(discount[i-10], 0);
            map.put(discount[i-10], tmp - 1);
            
            if (checkDiscount(map, want, number))
                answer++;
        }
        
        return answer;
    }
    
    private static boolean checkDiscount(Map<String, Integer> map, String[] want, int[] number) {
        boolean can = true;
        for(int i = 0; i < want.length; i++) {
            int tmp = map.getOrDefault(want[i], 0);
            if (tmp < number[i]) {
                can = false;
                break;
            }
        }
        return can;
    }
}
