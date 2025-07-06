import java.util.*;

public class Solution {
  
    public static int diceSolver(int[] A, int[] B, int R) {
        Set<Integer> setA = normalize(A);
        Set<Integer> setB = normalize(B);
    
        int max = 0;
    
        for (int i = 1; i <= R; i++) {
            String s = String.format("%03d", i);
            int[] digits = new int[3];
            for (int j = 0; j < 3; j++) {
                digits[j] = convert(s.charAt(j) - '0');
            }
    
            // 세 자리 수에서 A, B 주사위로 채울 수 있는 2자리 찾기
            boolean possible = false;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (x == y) continue;
                    int z = 3 - x - y;
    
                    if (setA.contains(digits[x]) && setB.contains(digits[y])) {
                        possible = true;
                        break;
                    }
                }
                if (possible) break;
            }
            if (possible) max++;
        }
    
        return max;
    }
    
    private static Set<Integer> normalize(int[] arr) {
        Set<Integer> result = new HashSet<>();
        for (int n : arr) result.add(convert(n));
        return result;
    }

    private static int convert(int n) {
        return (n == 6 || n == 9) ? 6 : n;
    }


    public static void main(String[] args) {
        // 테스트 케이스 리스트 생성
        List<TestCase> testCases = new ArrayList<>();

        testCases.add(new TestCase(
            new int[]{0, 1, 2, 6, 7, 8},
            new int[]{0, 2, 3, 4, 5, 6},
            15,
            15
        ));

        testCases.add(new TestCase(
            new int[]{1, 3, 5, 6, 7, 9},
            new int[]{0, 1, 4, 5, 6, 8},
            20,
            16 
        ));
        
          testCases.add(new TestCase(
            new int[]{1, 3, 5, 6, 7, 9},
            new int[]{0, 1, 4, 5, 6, 8},
            200,
            182 
        ));
          testCases.add(new TestCase(
            new int[]{1, 2, 5, 6, 7, 9},
            new int[]{0, 1, 4, 3, 6, 8},
            10000,
            857 
        ));

        // 테스트 실행 및 결과 확인
        int passed = 0;
        for (int i = 0; i < testCases.size(); i++) {
            TestCase tc = testCases.get(i);
            int result = diceSolver(tc.a, tc.b, tc.R);
            if (result == tc.expected) {
                System.out.println("✅ Test case " + (i + 1) + " passed");
                passed++;
            } else {
                System.out.println("❌ Test case " + (i + 1) + " failed");
                System.out.println("   expected: " + tc.expected);
                System.out.println("   but got : " + result);
            }
        }
        System.out.println("\n총 " + passed + " / " + testCases.size() + " 케이스 통과");
    }


    // 테스트 케이스 클래스
    static class TestCase {
        int[] a;
        int[] b;
        int R;
        int expected;

        TestCase(int[] a, int[] b, int R, int expected) {
            this.a = a;
            this.b = b;
            this.R = R;
            this.expected = expected;
        }
    }
}
