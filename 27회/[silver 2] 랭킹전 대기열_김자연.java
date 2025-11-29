import java.util.*;
import java.io.*;

public class Main {
  static class Room {
    PriorityQueue<Player> players;
    int level;
    
    public Room(int level, Player player) {
      if(players == null) players = new PriorityQueue<>();
      players.add(player);
      this.level = level;
    }
  }
  
  static class Player implements Comparable<Player> {
    String name;
    int level;
    
    public Player(int level, String name) {
      this.name = name;
      this.level = level;
    }
    
    @Override
    public int compareTo(Player o) {
      return this.name.compareTo(o.name);
    }
  }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Room> rooms = new ArrayList<>();
        
        outer: for(int i=0;i<p;i++) {
          st = new StringTokenizer(br.readLine());
          int level = Integer.parseInt(st.nextToken());
          String name = st.nextToken();
          
          Player plyr = new Player(level, name);
          
          if(rooms.isEmpty()) {
            rooms.add(new Room(level, plyr));
            continue;
          }
          
          for(Room room : rooms) {
            if(room.level-10 <= level && level <= room.level+10 && room.players.size() < m) {
              room.players.add(plyr);
              continue outer;
            }
          }
          
          rooms.add(new Room(level, plyr));
        }
        
        StringBuffer sb = new StringBuffer();
        for(Room room : rooms) {
          if(room.players.size() == m) sb.append("Started!");
          else if(room.players.size() < m) sb.append("Waiting!");
          sb.append('\n');
          
          while(!room.players.isEmpty()) {
            Player plyr = room.players.poll();
            sb.append(plyr.level).append(' ').append(plyr.name).append('\n');
          }
        }
        
        System.out.print(sb);
    }
}
