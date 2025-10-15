import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        List<String> union = new ArrayList<>();
        List<String> intersect = new ArrayList<>();
        
        // 다중집합
        for(int i=0;i<str1.length()-1;i++) {
            StringBuffer sb = new StringBuffer();
            if(!Character.isLetter(str1.charAt(i)) || !Character.isLetter(str1.charAt(i+1))) continue;
            sb.append(str1.charAt(i)).append(str1.charAt(i+1));
            map1.put(sb.toString(), map1.getOrDefault(sb.toString(), 0)+1);
        }
        
        for(int i=0;i<str2.length()-1;i++) {
            StringBuffer sb = new StringBuffer();
            if(!Character.isLetter(str2.charAt(i)) || !Character.isLetter(str2.charAt(i+1))) continue;
            sb.append(str2.charAt(i)).append(str2.charAt(i+1));
            map2.put(sb.toString(), map2.getOrDefault(sb.toString(), 0)+1);
        }
        
        // union
        for(String str : map1.keySet()) {
            if(!map2.containsKey(str)) {
                for(int i=0;i<map1.get(str);i++) {
                    union.add(str);
                }
            } else {
                for(int i=0;i<Math.max(map1.get(str), map2.get(str));i++) {
                    union.add(str);
                }
            }
        }
        
        for(String str : map2.keySet()) {
            if(map1.containsKey(str)) continue;
            for(int i=0;i<map2.get(str);i++) {
                union.add(str);
            }
        }
        
        // interect
        for(String str : map1.keySet()) {
            if(!map2.containsKey(str)) continue;
            for(int i=0;i<Math.min(map1.get(str), map2.get(str));i++) {
                intersect.add(str);
            }
        }
        
        if(union.size() == 0 && intersect.size() == 0) return 65536; 
        
        double answer = (double) intersect.size() / union.size() * 65536;
        return (int) answer;
    }
}
