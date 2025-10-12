import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> m1 = makeSet(str1.toUpperCase());
        Map<String, Integer> m2 = makeSet(str2.toUpperCase());
        
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(m1.keySet());
        allKeys.addAll(m2.keySet());
        
        Map<String, Integer> intersection = new HashMap<>();
        Map<String, Integer> union = new HashMap<>();

        
        for(String s : m1.keySet()) {
            if(m2.containsKey(s)) {
                intersection.put(s, Math.min(m1.get(s), m2.get(s)));
            }
        }
        
        for(String key : allKeys) {
            union.put(key, Math.max(m1.getOrDefault(key, 0), m2.getOrDefault(key, 0)));
        }
        
        float a = 0, b = 0;
        for(String s : intersection.keySet()) {
            a += intersection.get(s);
        }
        for(String s : union.keySet()) {
            b += union.get(s);
        }

        if (b == 0)
            return 65536;
        
        return (int)(a / b * 65536);
    }
    
    public Map<String, Integer> makeSet(String s) {
        Map<String, Integer> m = new HashMap<>();
        
        for(int i = 1; i < s.length(); i++) {
            char c1 = s.charAt(i-1);
            char c2 = s.charAt(i);
            
            if (!isChar(c1) || !isChar(c2)) {
                continue;
            }   
            String str = s.substring(i-1, i+1);
            m.put(str, m.getOrDefault(str, 0)+1);
        }
        return m;
    }
    
    public boolean isChar(char c) {
        return (c >= 65 && c <= 90);
    }
}
