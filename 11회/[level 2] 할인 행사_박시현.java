// 지선생 코드입니두..

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        final int WINDOW = 10;
        if (discount.length < WINDOW) return 0;

        // 1) 필요한 품목 카운트
        Map<String, Integer> need = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            need.put(want[i], number[i]);
        }

        // 2) 처음 10일 창 세팅 (원하는 품목만 카운트)
        Map<String, Integer> window = new HashMap<>();
        for (int i = 0; i < WINDOW; i++) {
            String item = discount[i];
            if (need.containsKey(item)) {
                window.put(item, window.getOrDefault(item, 0) + 1);
            }
        }

        int answer = 0;
        if (matches(need, window)) answer++;

        // 3) 슬라이딩
        for (int start = 1; start + WINDOW - 1 < discount.length; start++) {
            String out = discount[start - 1];            // 창에서 빠지는 하루
            String in  = discount[start + WINDOW - 1];   // 새로 들어오는 하루

            if (need.containsKey(out)) {
                int c = window.get(out) - 1;
                if (c == 0) window.remove(out);
                else window.put(out, c);
            }
            if (need.containsKey(in)) {
                window.put(in, window.getOrDefault(in, 0) + 1);
            }

            if (matches(need, window)) answer++;
        }

        return answer;
    }

    // window가 need를 모두 만족(>=)하는지 검사
    private boolean matches(Map<String, Integer> need, Map<String, Integer> window) {
        for (Map.Entry<String, Integer> e : need.entrySet()) {
            if (window.getOrDefault(e.getKey(), 0) < e.getValue()) return false;
        }
        return true;
    }
}
