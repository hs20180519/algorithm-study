import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 정원
        
        // 플레이어
        Queue<Player> players = new LinkedList<>();
        
        // 방
        Queue<Room> rooms = new LinkedList<>();
        
        // 플레이어 저장
        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            players.add(new Player(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        
        // 배정 시작
        while(!players.isEmpty()) {
            Player cur = players.poll();
            boolean assigned = false;
            
            for (Room r : rooms) {
                if(!r.isFull() && r.canJoin(cur)) { // 방이 가득 차있지 않고, 기준점수 범위 내인 경우
                    r.roomPlayers.add(cur); // 플레이어 추가
                    assigned = true;
                    break; // 첫 번째 들어갈 수 있는 방에 넣고 끝
                }
            }
            
            // 방이 없는 경우
            if (!assigned) {
                rooms.add(new Room(cur, m));
            }
        }
        
        int roomCount = rooms.size();
        for(int i = 0; i < roomCount; i++) {
            Room roomCheck = rooms.poll();
            
            if(roomCheck.roomPlayers.size() == m){
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            
            roomCheck.roomPlayers.sort(Comparator.comparing(pl -> pl.name));
            
            for (Player pl : roomCheck.roomPlayers) {
                System.out.println(pl.level + " " + pl.name);
            }
        }
    }
}

class Player {
    int level;
    String name;
    
    Player(int level, String name) {
        this.level = level;
        this.name = name;
    }
}

class Room {
    List<Player> roomPlayers = new ArrayList<>();
    int baseLevel;
    int capa;
    
    Room(Player first, int capa) {
        this.roomPlayers.add(first);
        this.baseLevel = first.level;
        this.capa = capa;
    }
    
    boolean isFull() {
        return roomPlayers.size() >= capa;
    }
    
    boolean canJoin(Player p) {
        return Math.abs(p.level - baseLevel) <= 10;
    }
}
