import java.util.*;

class Solution {
    public static class Song implements Comparable<Song> {
        int num;
        int play;
        
        public Song(int num, int play) {
            this.num = num;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song o1) {
            return o1.play - this.play;
        }
    }
    
    static int N;
    public int[] solution(String[] genres, int[] plays) {
        N = genres.length;
        
        Map<String, PriorityQueue<Song>> songs = new HashMap<>();
        Map<String, Integer> playsByGenre = new HashMap<>();
        
        for(int i=0;i<N;i++) {
            String genre = genres[i];
            int play = plays[i];
            Song song = new Song(i, play);
            
            PriorityQueue<Song> songList = songs.getOrDefault(genre, new PriorityQueue<Song>());
            songList.add(song);
            songs.put(genre, songList);
            
            int total = play + playsByGenre.getOrDefault(genre, 0);
            playsByGenre.put(genre, total);
            
        }
        
        List<Map.Entry<String, Integer>> totalList = new ArrayList<>(playsByGenre.entrySet());
        totalList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        List<Integer> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : totalList) {
            String key = entry.getKey();
            
            PriorityQueue<Song> songList = songs.get(key);
            
            answer.add(songList.poll().num);
            if(!songList.isEmpty()) {
                answer.add(songList.poll().num);
            }
        }
        
        int result[] = new int[answer.size()];
        for(int i=0;i<answer.size();i++) {
            result[i] = (int) answer.get(i);
        }
        
        return result;
    }
}
