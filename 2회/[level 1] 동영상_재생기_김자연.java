import java.util.*;

class Solution {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] splited = pos.split(":");
        int posMin = Integer.parseInt(splited[0]);
        int posSec = Integer.parseInt(splited[1]);
        
        int posTime = posMin * 60 + posSec;
        
        String[] opStartSplited = op_start.split(":");
        int opStartMin = Integer.parseInt(opStartSplited[0]);
        int opStartSec = Integer.parseInt(opStartSplited[1]);
        
        int opStartTime = opStartMin*60 + opStartSec;
        
        String[] opEndSplited = op_end.split(":");
        int opEndMin = Integer.parseInt(opEndSplited[0]);
        int opEndSec = Integer.parseInt(opEndSplited[1]);
        
        int opEndTime = opEndMin*60 + opEndSec;
        
        String[] videoLenSplited = video_len.split(":");
        int videoLenMin = Integer.parseInt(videoLenSplited[0]);
        int videoLenSec = Integer.parseInt(videoLenSplited[1]);
        
        int videoLenTime = videoLenMin*60 + videoLenSec;
        
        for(int i=0;i<commands.length;i++) {
            String cmd = commands[i];
            
            
            
            if(opStartTime <= posTime && posTime <= opEndTime) {
                posTime = opEndTime;
            }
            
            switch(cmd) {
                case "next":
                    posTime = posTime + 10 > videoLenTime ? videoLenTime : posTime + 10;
                    break;
                case "prev":
                    posTime = posTime - 10 < 0 ? 0 : posTime - 10;
                    break;
                default:
                    break;
            }
            
            if(opStartTime <= posTime && posTime <= opEndTime) {
                posTime = opEndTime;
            }
        }
        
        posMin = posTime / 60;
        posSec = posTime % 60;
        String answerMin = posMin < 10 ? "0"+posMin : posMin+"";
        String answerSec = posSec < 10 ? "0"+posSec : posSec+"";
        
        return answerMin+":"+answerSec;
    }
}
