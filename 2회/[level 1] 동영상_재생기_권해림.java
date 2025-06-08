import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {        
        Player player = new Player(parseTime(pos), parseTime(video_len), parseTime(op_start), parseTime(op_end));
        
        
        for(String command : commands){
            player.skip();
            if(command.equals("prev")) player.prev();
            else player.next();
            player.skip();
        }
        
        return String.format("%02d:%02d", player.time / 60, player.time % 60);
    }
    
    public int parseTime(String string){
        String[] time = string.split(":");
        
        int hh = Integer.parseInt(time[0]);
        int mm = Integer.parseInt(time[1]);
        
        return 60*hh + mm;
    }
}

class Player{
    int time=0, endTime, opStart, opEnd;
    
    public Player(int time, int endTime, int opStart, int opEnd){
        this.time = time;
        this.endTime = endTime;
        this.opStart = opStart;
        this.opEnd = opEnd;
    }
    
    public void skip(){
        if(opStart <= time && time <= opEnd) time = opEnd;
    }
    
    public void prev(){
        time = time >= 10 ? time - 10 : 0;
    }
    
    public void next(){
        time = (time + 10 <= endTime) ? time + 10 : endTime;
    }
        
}
