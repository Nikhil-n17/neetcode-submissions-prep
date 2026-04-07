class Solution {
    private boolean freshOrangeExist(int[][] grid, int row, int col) {
        for(int i = 0 ; i < row ; i++) {
            for(int j = 0 ; j < col ; j++) {
                if(grid[i][j] == 1) return true;
            }
        }
        return false;
    }
    private int getRottenOrangesCount(int[][] grid, int row, int col) {
        int count = 0;
        for(int i = 0 ; i < row ; i++) {
            for(int j = 0 ; j < col ; j++) {
                if(grid[i][j] == 2) count+=1;
            }
        }
        return count;
    }
    private List<int[]> updateAndReturnRottenIndices(int[][] grid, List<int[]> rottenIndices, int row, int col) {
        List<int[]> affectedIndices = new ArrayList<>();
        for(int[] index: rottenIndices) {
            int aRow = index[0];
            int aCol = index[1];
            System.out.printf("%d %d\n", index[0], index[1]);
            if(aRow + 1 < row) {
                if(grid[aRow+1][aCol]== 1) {
                    grid[aRow+1][aCol] = 2;
                    affectedIndices.add(new int[] {aRow+1, aCol});
                }
            }
            if(aRow - 1 >= 0) {
                if(grid[aRow-1][aCol] == 1) {
                    grid[aRow-1][aCol] = 2;
                    affectedIndices.add(new int[] {aRow-1, aCol});
                }
            }
            if(aCol + 1 < col) {
                if(grid[aRow][aCol+1]== 1) {
                    grid[aRow][aCol+1] = 2;
                    affectedIndices.add(new int[] {aRow, aCol+1});
                }
            }
            if(aCol - 1 >= 0) {
                if(grid[aRow][aCol-1]==1) {
                    grid[aRow][aCol-1] = 2;
                    affectedIndices.add(new int[] {aRow, aCol-1});
                }
            }
        }
        return affectedIndices;
    }
    private List<int[]> getRottenIndicesInitially(int[][] grid, int row, int col) {
        List<int[]> affectedIndices = new ArrayList<>();
        for(int i = 0 ; i < row ; i++) {
            for(int j = 0 ; j < col ; j++) {
                if(grid[i][j] == 2) affectedIndices.add(new int[]{i,j});
            }
        }
        return affectedIndices;
    }
    private void printIndices(int[][] grid, List<int[]> indices) {
        for(int[] index : indices) {
            System.out.printf("%d %d\n", index[0], index[1]);
        }
        System.out.println("Completed");
    }
    public int orangesRotting(int[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        List<int[]> affectedIndices = getRottenIndicesInitially(grid,row,col);
        printIndices(grid, affectedIndices);
        while(freshOrangeExist(grid, row, col)) {
            int prev = getRottenOrangesCount(grid, row,col);
            System.out.println("Count : P : " + prev);
            printIndices(grid, affectedIndices);
            affectedIndices = updateAndReturnRottenIndices(grid, affectedIndices, row, col);
            int after = getRottenOrangesCount(grid, row,col);
            if(prev == after) return -1;
            res+=1;
        }
        return res;
    }
}
