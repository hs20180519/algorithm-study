import java.io.*;
import java.util.*;

class Solution {
    HashSet<String> set = new HashSet<>();

    public int solution(String str1, String str2) throws Exception {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        HashMap<String, Integer> aMap = new HashMap<>();
        HashMap<String, Integer> bMap = new HashMap<>();

        splitTwo(str1, aMap);
        splitTwo(str2, bMap);

        int inter = 0;
        int union = 0;

        for (String key : set) {
            int aCount = aMap.getOrDefault(key, 0);
            int bCount = bMap.getOrDefault(key, 0);
            inter += Math.min(aCount, bCount);
            union += Math.max(aCount, bCount);
        }

        float jacard = (union == 0) ? 1 : (float) inter / union;
        return (int) (jacard * 65536);
    }

    void splitTwo(String targetString, HashMap<String, Integer> map) {
        for (int i = 0; i < targetString.length() - 1; i++) {
            String str = targetString.substring(i, i + 2);
            if (!isAlpha(str)) continue;
            int size = map.getOrDefault(str, 0);
            map.put(str, size + 1);
            set.add(str); 
        }
    }

    boolean isAlpha(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!('A' <= s.charAt(i) && s.charAt(i) <= 'Z')) return false;
        }
        return true;
    }
}
