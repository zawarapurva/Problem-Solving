// https://leetcode.com/problems/n-queens/

// Time Complexity: O(n!)
// Space Complexity: O(n + n!)

class Solution {
    List<List<String>> result;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        this.grid = new boolean[n][n];
        this.result = new ArrayList<>();
        backtrack(0,n); //we will pass only rows not whole grid and number of rows and columns i.e. n
        return result;
    }

    private void backtrack(int row, int n){
        //base
        if(row == n){
            List<String> re = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if(grid[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                re.add(sb.toString());
            }
            result.add(re);
            return;
        }

        //logic
        for (int column = 0; column < n; column++) {
            if (isSafe(row,column, n)) {
                //action
                grid[row][column] = true;
                //recurse
                backtrack(row + 1,n);
                //backtrack
                grid[row][column] = false;
            }
        }
    }

    private boolean isSafe(int row, int column, int n){
        //column up
        for (int i = 0; i < row; i++) {
            if(grid[i][column]) return false;
        }

        //diagonal up right
        int i = row; int j =column;
        while (i >= 0 && j < n ) {
            if(grid[i][j]) return false;
            i--; j++;
        }
        i = row; j = column;

        //diagonal up left
        while (i >= 0 && j >= 0 ) {
            if(grid[i][j]) return false;
            i--; j--;
        }
        return true;
    }
}