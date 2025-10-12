import java.util.*;

class Solution {
    String moeum = "AEIOU";
    List<String> arr;
    public int solution(String word) {
        arr = new ArrayList<>();
        dfs(0, new char[5]);
        
        Collections.sort(arr);
 
        while(word.length() < 5){
            word += '0';
        }
   
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i).equals(word)){
                return i;
            }
        }
        
        return 0;
    }
    
    public void dfs(int depth, char[] temp){
        
        for(int i=0; i<5; i++){
            if(temp[i] == 0){
                temp[i] = '0';
            }
        };
        
        arr.add(String.valueOf(temp));
        
        if(depth == 5){
            return;
        }
        
        for(int i=0; i<5; i++){
            temp[depth] = moeum.charAt(i);
            dfs(depth+1, temp);
            temp[depth] = '0';
        }
    }
}
