import java.util.*;

public class Solution {
  
    // 첫 번째 주사위와 두 번째 주사위는 고정 숫자 6,
    // 세 번째 주사위는 6개 숫자 선택
    public static int diceSolver(int[] A, int[] B, int R) {
      int answer = 0;
      
      Set<Integer> setA = changeSet(A);
      Set<Integer> setB = changeSet(B);
  
      // 모든 C 조합에 대해 확인 시작
      List<int[]> result = new ArrayList<>();
      int[] cur = new int[6];
      
      generateComb(0, 0, cur, result);
      
      for(int[] comb : result) {
        Set<Integer> setC = changeSet(comb);
        int count = 0;
        
        for(int r = 1; r <= R; r++) {
          if (canMake(r, setA, setB, setC))
            count++;
        }
        
        answer = Math.max(answer, count);
      }
      
      return answer;
    }
    
    // 6 - 9 호환성 체크하면서 Set으로 변환
    static Set<Integer> changeSet(int[] arr) {
      Set<Integer> tmp = new HashSet<Integer>();
      for (int i = 0; i < arr.length; i++) {
        tmp.add(arr[i]);
        
        if (arr[i] == 6)
          tmp.add(9);
        
        else if (arr[i] == 9)
          tmp.add(6);
      }
      return tmp;
    }
    
    // 길이 6인 조합 만들기
    static void generateComb(int start, int depth, int[] cur, List<int[]> result) {
      if (depth == 6) {
        result.add(cur.clone());
        return;
      }
      
      for (int i = start; i <= 9; i++) {
        cur[depth] = i;
        generateComb(i+1, depth+1, cur, result);
      } 
    }
    
    // A, B, C Set으로 해당 number를 만들 수 있는지 유무 확인
    static boolean canMake(int number, Set<Integer> setA, Set<Integer> setB, Set<Integer> setC) {
      int[] digits = {number / 100, (number / 10) % 10, number % 10}; // 1 -> 001 변환 
      
      Set<Integer>[] sets = new Set[] {setA, setB, setC};
      
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          for (int k = 0; k < 3; k++) {
            if (i != j && j != k && i != k) { // 6가지 순열 확인 (SetA, SetB, SetC)
              if (sets[i].contains(digits[0]) && sets[j].contains(digits[1]) && sets[k].contains(digits[2]))
                return true;
            }
          }
        }
      }
      return false;
    }
}
