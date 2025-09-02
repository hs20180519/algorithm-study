class Solution {
    long t;
    public void binarySearch(long start, long end, int[] cores, int n) {
        if(start > end) return;
        long mid = (start + end) / 2;
        
        long cnt = cores.length;
        for(int c : cores) {
            cnt += mid / c;
            if(cnt >= n) break;
        }
        
        if(cnt >= n) {
            t = Math.min(t, mid);
            binarySearch(start, mid-1, cores, n);
        } else binarySearch(mid+1, end, cores, n);
    }
    
    public int solution(int n, int[] cores) { // n: 작업개수
        int maxC = 0;
        for(int c: cores) {
            maxC = Math.max(maxC, c);
        }
        t = maxC*n;
        binarySearch(0, maxC*n, cores, n);
        
        int cnt = cores.length;
        for(int c : cores) {
            cnt += (t-1) / c;
        }
        
        int remain = n - cnt;
        int answer = 0;
        for(int i=0;i<cores.length;i++) {
            if(t%cores[i] == 0) {
                remain--;
                answer = i+1;
            }
            if(remain == 0) break;
        }
        return answer;
    }
}
