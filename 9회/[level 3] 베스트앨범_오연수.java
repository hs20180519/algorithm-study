import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap <String, Album> albumHash = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            Album tmp = albumHash.getOrDefault(genres[i], new Album());
            tmp.addSong(i, plays[i]);
            albumHash.put(genres[i], tmp);
        }
        
        // 해시맵 -> 리스트로 변환 후 최대재생수 내림차순 정렬
        List<Album> list = new ArrayList<>(albumHash.values());
        Collections.sort(list);
        
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            Album tmp = list.get(i);
            answer.add(tmp.idxList.get(0)[0]);
            if (tmp.idxList.size() > 1) {
                answer.add(tmp.idxList.get(1)[0]);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Album implements Comparable<Album> {
    List<int[]> idxList;
    int totalPlays;
    
    public Album() {
        this.idxList = new ArrayList<>();
        this.totalPlays = 0;
    }
    
    public void addSong(int idx, int plays) {
        idxList.add(new int[]{idx, plays});
        totalPlays += plays;
        sortSongs();
    }
    
    private void sortSongs() {
        idxList.sort((a, b) -> {
            if (b[1] != a[1]) {
                return b[1] - a[1]; // plays 내림차순
            }
            return a[0] - b[0]; // idx 오름차순
        });
    }
    
    public int compareTo(Album o) {
        return o.totalPlays - this.totalPlays;
    }
}
