public class Main {
    
    public static int makeGroups(int[] students) {
        // 배열의 길이
        int n = students.length;
        int cnt = 0;
        
        // Subarray(연속 부분 배열) 
        // 원래 배열에서 연속된 위치에 있는 요소들만 떼어낸 배열
        for(int i = 0; i < n; i++) {
          boolean foundOne = false;
          
          for(int j = i; j < n; j++) {
            if(students[j] == 1) {
              foundOne = true;
            }
            if(foundOne) {
              cnt++;
            }
          }
        }
        
        return cnt;
    }
}
