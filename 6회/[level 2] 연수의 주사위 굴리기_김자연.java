import java.util.*;

public class Solution {
  static int answer, R;
  static int aDice[], bDice[], cDice[];
  
  public static void comb(int start, int depth) {
    if(depth == 6) {
      int count = check();
      answer = Math.max(count, answer);
      return;
    }
    
    for(int i=start;i<10;i++) {
      cDice[depth] = i;
      comb(i+1, depth+1);
    }
  }
  
  public static List<int[]> perm(List<int[]> list, int cand[], int depth, int result[], boolean isSelected[]) {
    if(depth == 3) {
      list.add(result.clone());
      return list;
    }
    
    for(int i=0;i<3;i++) {
      if(isSelected[i]) continue;
      result[depth] = cand[i];
      isSelected[i] = true;
      perm(list, cand, depth + 1, result, isSelected);
      isSelected[i] = false;
    }
    
    return list;
  }
  
  public static int check() {
    int count = 0;
    for(int i=1;i<=R;i++) {
        int x = i;
        
        int a = x / 100;
        x %= 100;
        
        int b = x / 10;
        x %= 10;
        
        int c = x;
        
        
        for(int[] cand: perm(new ArrayList<int[]>(), new int[] {a, b, c}, 0, new int[3], new boolean[3])) {
          if(has(cand[0], aDice) &&
          has(cand[1], bDice) &&
          has(cand[2], cDice)) {
            count++;
            break;
          }
        }
        
      }
      
      return count;
  }
  
    public static int diceSolver(int[] A, int[] B, int R) {
      Solution.R = R;
      aDice = A;
      bDice = B;
      
      cDice = new int[6];
      comb(0, 0);
    
      return answer;
    }
    
    public static boolean has(int x, int[] arr) {
      if(x == 6 || x == 9) {
        return Arrays.stream(arr).anyMatch(a -> a == 6 || a == 9);
      }
      
      return Arrays.stream(arr).anyMatch(a -> a == x);
    }
}
