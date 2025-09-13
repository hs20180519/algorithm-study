class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers, n);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, boolean[] visited, int[][] computers, int n) {
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (computers[i][j] == 1 && !visited[j]) {
                dfs(j, visited, computers, n);
            }
        }
    }
}
