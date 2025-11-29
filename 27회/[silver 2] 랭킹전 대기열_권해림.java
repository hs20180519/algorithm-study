import java.io.*;
import java.util.*;

public class Main {

    static class Player {
        int level;
        String name;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    static class Room {
        int baseLevel;  
        ArrayList<Player> players;

        Room(int baseLevel) {
            this.baseLevel = baseLevel;
            this.players = new ArrayList<>();
        }

        boolean canEnter(Player p) {
            return p.level >= baseLevel - 10 && p.level <= baseLevel + 10;
        }

        boolean isFull(int m) {
            return players.size() == m;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nick = st.nextToken();

            Player newPlayer = new Player(level, nick);

            boolean entered = false;

            for (Room room : rooms) {
                if (!room.isFull(M) && room.canEnter(newPlayer)) {
                    room.players.add(newPlayer);
                    entered = true;
                    break;
                }
            }

            if (!entered) {
                Room newRoom = new Room(level);
                newRoom.players.add(newPlayer);
                rooms.add(newRoom);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if (room.players.size() == M) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            room.players.sort(Comparator.comparing(p -> p.name));

            for (Player p : room.players) {
                sb.append(p.level).append(" ").append(p.name).append("\n");
            }
        }

        System.out.print(sb);
    }
}
