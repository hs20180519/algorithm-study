public class Solution {
    public static int[] solution(int[][] records) {
        int n = records.length;
        
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++){
          arr[i][0] = records[i][0];
          arr[i][1] = records[i][1];
          arr[i][2] = i+1; // 실제 번호
        }
        
        Arrays.sort(arr, (a,b) -> a[1]-b[1]); // 오름차순 정렬
        
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++){
          if(arr[i][0] >= i+1){
            answer[arr[i][2]-1] = 1; 
          }else{
            answer[arr[i][2]-1] = 0;
          }
        }
        
        return answer;
    }
}
