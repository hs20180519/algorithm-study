class Solution {
    public int solution(int n, int w, int num) {
        int tx = ((num-1)/w) % 2 == 0 ? (num-1)%w : w - ((num-1)%w) - 1;
        int ty = (num-1)/w;
        
        boolean flag = ((n-1)/w) % 2 == 0;
        int topx = flag ? (n-1)%w : w - ((n-1)%w) - 1;
        int topy = (n-1)/w;
        
        if(flag) topx >= tx ? topy - ty + 1 : topy - ty; // 짝수층
        else return topx <= tx ? topy - ty + 1 : topy - ty; // 홀수층
    }
}
