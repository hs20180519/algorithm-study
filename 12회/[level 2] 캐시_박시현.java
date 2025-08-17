import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // HashMap은 순서를 보장x, LinkedHashMap은 삽입 순서 또는 접근 순서 보장
        // accessOrder = true를 통해 최근 접근 순서대로 유지
        // (가장 오래 안 쓰인 항목 항상 맨 앞, 제거 쉬움)
        Map<String, Boolean> cache = new LinkedHashMap<>(cacheSize, 0.75f, true);
        
        if(cacheSize <= 0) {
            return cities.length * 5;
        }
        
        int time = 0;
        
        for(String city : cities) {
            String lowerCity = city.toLowerCase();
            // LinkedHashMap 내에 존재하는지 확인, hit || miss 계산
            if(cache.containsKey(lowerCity)) { 
                time += 1;
            } else {
                time += 5;
            }
            
            // 순서 갱신, LRU 관리되는 부분
            cache.put(lowerCity, Boolean.TRUE);
            
            // HashMap/LinkedHashMap은 용량 초과 시 자동으로 가장 오래된 데이터 지워주지x, 직접관리
            // .keySet() -> Map에 들어있는 모든 key의 집합(Set) 반환
            // .iterator() -> 내부적으로 처음, 다음,... 순서로 이동
            if(cache.size() > cacheSize) {
                Iterator<String> it = cache.keySet().iterator();
                it.next(); // 가장 오래된 키
                it.remove();
            }
            
        }
        return time;
    }
}
