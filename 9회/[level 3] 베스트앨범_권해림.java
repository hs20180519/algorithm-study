import java.util.*;

class Music implements Comparable<Music> {    
    int id;
    int play;
    
    public Music(int id, int play){
        this.id = id;
        this.play = play;
    }
    
    @Override
    public int compareTo(Music o){
        if (this.play == o.play) {
            return this.id - o.id; 
        }
        return o.play - this.play;
    }
}

class Solution {
    static Map<String, List<Music>> musicList;
    static Map<String, Integer> genreToPlays;

    public int[] solution(String[] genres, int[] plays) {
        musicList = new HashMap<>();
        genreToPlays = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreToPlays.put(genre, genreToPlays.getOrDefault(genre, 0) + play);

            musicList.putIfAbsent(genre, new ArrayList<>());
            musicList.get(genre).add(new Music(i, play));
        }

        List<String> sortedGenres = new ArrayList<>(genreToPlays.keySet());
        sortedGenres.sort((a, b) -> genreToPlays.get(b) - genreToPlays.get(a));

        
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Music> songs = musicList.get(genre);
            Collections.sort(songs); 

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).id);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
