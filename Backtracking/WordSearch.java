// https://leetcode.com/problems/word-search/
// Time complexity: O(m x n x 3 ^ L)
// Space complexity: O(L)

class Solution {
    int[][] dirs;
    int m, n;
    public boolean exist(char[][] board, String word) {
        // down right left up
        this.dirs = new int[][]{{1,0}, {0,1}, {0,-1}, {-1, 0}};
        this.m = board.length;
        this.n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j<n; j++) {
                if(board[i][j]==word.charAt(0)) {
                    if(helper(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int idx, int r, int c) {
        //base
        if(idx == word.length()) return true;
        //bounds check
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#' ) {
            return false;
        }

        //logic
        if(board[r][c] == word.charAt(idx)) {
            //action
            board[r][c] = '#';

            //recurse
            for(int[] dir: dirs) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if(helper(board, word, idx+1, nr, nc)) return true;
            }

            //backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}

