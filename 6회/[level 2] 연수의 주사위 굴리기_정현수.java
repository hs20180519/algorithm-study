// 1. A, B에서 6이나 9가 있으면 9나 6을 추가한 Set을 만듦 (HashSet)
// 2. C는 0부터 9이므로, 이중에서(10개) 6개를 뽑는 조합을 만듦 (combinations)
// 3. C중에 하나씩 뽑아서, 6, 9를 추가한 Set을 만듦
// 4. 그 후, 1부터 R까지의 숫자 중에서, 만들 수 있는지 판별해야 함
// 5. 이를 String 3d으로 바꾸고, int digits[3] 배열에 각각 저장 (1 -> "001" -> [0, 0, 1])
// 6. perms(순열 인덱스 : (0,1,2), (0,2,1) ...) 반복문을 돌려서 각 인덱스에 맞춰 만들 수 있는지 확인해야 함
// 7. A, B, C Set이 담긴 배열을 만듦. 배열[0] = {0,1,2,3,4,5} (주사위 A Set)
// 8. 012중 0이 A에 존재하는지 확인, 1이 B에 존재하는지 확인, 2이 C에 존재하는지 확인
// 9. 존재하면 canMake = true, count ++
// 10. 존재하지 않는다면 perm 변경, 012중 0이 A에 존재하는지 확인, 2이 B에 존재하는지 확인, 3이 C에 존재하는지 확인
// 11. count 값이 최대일 때 반환

// 각 숫자를 3자리 수로 나눈 후에 각 자릿수를 배치할 수 있는지 6가지 순열로 시도(Set, contains)
import java.util.*;

public class DiceNumberSolver {

    public static void main(String[] args) {
        // A, B 주사위 고정
        int[] A = {0, 1, 2, 6, 7, 8};
        int[] B = {0, 2, 3, 4, 5, 6};
        int R = 15; // 만들고 싶은 수 범위 (1~R)

        System.out.println(getMaxCreatableCount(A, B, R));
    }

    public static int getMaxCreatableCount(int[] A, int[] B, int R) {
        // A, B 확장 (6 ↔ 9 포함)
        Set<Integer> dieA = expandDigits(A);
        Set<Integer> dieB = expandDigits(B);

        List<int[]> cCombinations = generateCombinations();
        int maxCount = 0;

        for (int[] cRaw : cCombinations) {
            Set<Integer> dieC = expandDigits(cRaw);
            int count = 0;

            // 숫자 001 ~ R까지 시도
            for (int num = 1; num <= R; num++) {
                String s = String.format("%03d", num); // 항상 3자리
                int[] digits = new int[3];
                for (int i = 0; i < 3; i++) digits[i] = s.charAt(i) - '0';

                // A, B, C 주사위 순서의 모든 조합 (3! = 6)
                boolean canMake = false;
                int[][] perms = {
                    {0, 1, 2}, {0, 2, 1},
                    {1, 0, 2}, {1, 2, 0},
                    {2, 0, 1}, {2, 1, 0}
                };

                for (int[] perm : perms) {
                    Set<Integer>[] dice = new Set[] {dieA, dieB, dieC};
                    if (dice[perm[0]].contains(digits[0]) &&
                        dice[perm[1]].contains(digits[1]) &&
                        dice[perm[2]].contains(digits[2])) {
                        canMake = true;
                        break;
                    }
                }

                if (canMake) count++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    // 6 ↔ 9 확장 처리
    public static Set<Integer> expandDigits(int[] digits) {
        Set<Integer> result = new HashSet<>();
        for (int d : digits) {
            result.add(d);
            if (d == 6 || d == 9) {
                result.add(d == 6 ? 9 : 6);
            }
        }
        return result;
    }

    // 0~9 중 6개를 선택하는 모든 조합 생성
    public static List<int[]> generateCombinations() {
        List<int[]> result = new ArrayList<>();
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) nums[i] = i;

        combine(nums, 0, new int[6], 0, result);
        return result;
    }

    // 조합 생성 (재귀)
    private static void combine(int[] nums, int start, int[] temp, int depth, List<int[]> result) {
        if (depth == 6) {
            result.add(temp.clone());
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp[depth] = nums[i];
            combine(nums, i + 1, temp, depth + 1, result);
        }
    }
}
