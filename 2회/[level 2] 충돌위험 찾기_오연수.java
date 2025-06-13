import java.io.*;
import java.util.*;

class Solution {
    static Queue<int[]>[] record;
    static int answer = 0;
    static int size = 0;
    
    public int solution(int[][] points, int[][] routes) {
        
        record = new LinkedList[routes.length];
        size = routes.length;
        
        for(int i = 0; i < size; i++) {
            record[i] = new LinkedList<>();
        }
        recordRoute(points, routes);
        findCollision();
        
        return answer;
    }
    
    private static void recordRoute(int[][] points, int[][] routes) {
        for (int i = 0; i < routes.length; i++) {
            int from = routes[i][0] - 1;
            int fromR = points[from][0] - 1;
            int fromC = points[from][1] - 1;
            
            record[i].add(new int[] {fromR, fromC});
            
            for(int j = 0; j < routes[i].length; j++) {
                int to = routes[i][j] - 1;
                int toR = points[to][0] - 1;
                int toC = points[to][1] - 1;
                
                while(fromR != toR) {
                    fromR = (fromR < toR) ? fromR + 1 : fromR - 1;
                    record[i].add(new int[] {fromR, fromC});
                }
                
                while(fromC != toC) {
                    fromC = (fromC < toC) ? fromC + 1 : fromC - 1;
                    record[i].add(new int[] {fromR, fromC});
                }
            }
        }
    }
    
    private static void findCollision() {
        int escapeRobots = 0;
        while(escapeRobots != size) {
            int[][] map = new int [101][101];
            escapeRobots = 0;
            for(int i = 0; i < size; i++) {
                if (record[i].isEmpty()) {
                    escapeRobots++;
                    continue;
                }
                int[] temp = record[i].poll();
                map[temp[0]][temp[1]] ++;
            }
            
            for(int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] > 1) {
                        answer++;
                    }
                }
            }
        }
    }
}
