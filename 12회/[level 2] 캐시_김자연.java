import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> cache = new LinkedList<>();
        
        if(cacheSize == 0) return cities.length * 5;
        
        int answer=0;
        for(String c : cities) {
            String city = c.toLowerCase();
            int idx = cache.indexOf(city);
            if(idx == -1) { // miss
                if(cache.size() >= cacheSize) {
                    cache.remove();
                }
                cache.add(city);
                answer += 5;
            } else { // hit
                cache.remove(idx);
                cache.add(city);
                answer++;
            }
        }
        return answer;
    }
}
