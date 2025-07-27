class Solution {
    public static long calculate(long[] arr) {
        // 인덱스가 0으로 시작하는 최대 합
        long max = arr[0];
        // 지금까지의 최대 합
        long curMax = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            // 지금까지의 합과 새로 시작하는 값 중 더 큰 값
            curMax = Math.max(arr[i], curMax + arr[i]);
            // 기존 max 값과 현재 인덱스에 있는 값을 더한 cur값 비교
            max = Math.max(max, curMax);
        }
        return max;
    }

    public long solution(int[] sequence) {
        // 각 1, -1로 시작하는 펄스 수열을 곱한 결과를 담은 배열 생성
        long plus[] = new long[sequence.length];
        long minus[] = new long[sequence.length];
        for(int i = 0; i < sequence.length; i++) {
            int plusPulse = (i % 2) == 0 ? 1 : -1;
            int minusPulse = -plusPulse;
            plus[i] = sequence[i] * plusPulse;
            minus[i] = sequence[i] * minusPulse;
        }
        
        // 최대값 구하기
        long plusMax = calculate(plus);
        long minusMax = calculate(minus);
        
        return Math.max(plusMax, minusMax);
    }
}
