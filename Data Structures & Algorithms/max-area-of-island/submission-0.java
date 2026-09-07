class Solution {
    private int[] dR = {-1, 1, 0, 0};
    private int[] dC = {0, 0, -1, 1};
    private boolean isValid(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
    private int dfs(int[][] grid, int[][] visited, int i, int j, int m, int n) {
        if(isValid(i,j,m,n) && grid[i][j] == 1 && visited[i][j] ==0) {
            visited[i][j] = 1;
            int nodeCount = 1;
            for(int k = 0 ; k < 4 ; k++) {
                int adjR = dR[k] + i;
                int adjC = dC[k] + j;
                nodeCount += dfs(grid, visited, adjR, adjC, m, n);
            }
            return nodeCount;
        }
        return 0;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int res = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0; j < n ; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    res = Math.max(res, dfs(grid,visited, i, j, m, n));
                }
            }
        }
        return res;
    }
}
