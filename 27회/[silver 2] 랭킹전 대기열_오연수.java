import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Room> rooms = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            
            map.put(nickname, l);
            
            if (rooms.isEmpty()) {
                rooms.add(new Room(m-1, l, nickname));
            } else {
                boolean flag = false;
                
                for(int j = 0; j < rooms.size(); j++) {
                    Room r = rooms.get(j);
                    
                    if (r.availableSeat > 0 && l <= r.level + 10 && l >= r.level - 10) {
                        flag = true;
                        r.availableSeat--;
                        r.players.add(nickname);
                        
                        break;
                    }
                }
                
                if (!flag) {
                    rooms.add(new Room(m-1, l, nickname));
                }
            }
        }
         for(int j = 0; j < rooms.size(); j++) {
            Collections.sort(rooms.get(j).players);
            
            if (rooms.get(j).availableSeat > 0) {
                sb.append("Waiting!\n");
                    for(String n : rooms.get(j).players) {
                        sb.append(map.get(n)).append(' ').append(n).append('\n');
                    }
            } else if (rooms.get(j).availableSeat == 0){
                sb.append("Started!\n");
                for(String n : rooms.get(j).players) {
                        sb.append(map.get(n)).append(' ').append(n).append('\n');
                }
            }
            
        }
        System.out.println(sb.toString());
    }
}

class Room {
    int availableSeat;
    int level;
    List<String> players;
    
    public Room(int availableSeat, int level, String startPlayer) {
        this.availableSeat = availableSeat;
        this.level = level;
        players = new ArrayList<>();
        players.add(startPlayer);
    }

}
