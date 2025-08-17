import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>(cacheSize);
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for(String city : cities){
            city = city.toUpperCase();
            
            if (contains(city, cache)) {
                answer += 1;
                cache.add(city);
            } else {
                answer += 5;
                if (!cache.isEmpty() && cache.size() == cacheSize)
                    cache.remove(0);
                cache.add(city);
            }
        }
        return answer;
    }
    
    public boolean contains(String city, List<String> cache) {
        Iterator it = cache.iterator();
        while(it.hasNext()) {
            String c = (String) it.next();
            if (c.toUpperCase().equals(city.toUpperCase())) {
                it.remove();
                return true;
            }
        }
        return false;
    }  
}
