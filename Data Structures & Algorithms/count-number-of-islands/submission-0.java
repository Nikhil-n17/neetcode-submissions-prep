class Solution {
    private void dfs(int i, int j, int m, int n, char[][] grid) {
        if( i < 0 || i >= m || j < 0 || j >= n) return;
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(i + 1, j, m, n , grid);
            dfs(i - 1, j, m, n , grid);
            dfs(i, j + 1, m, n , grid);
            dfs(i, j- 1, m, n , grid);
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == '1') {
                    dfs(i,j, m,n, grid);
                    count += 1;
                }
            }
        }
        return count;
    }
}
