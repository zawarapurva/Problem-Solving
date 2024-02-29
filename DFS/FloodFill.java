// https://leetcode.com/problems/flood-fill/

// Time Complexity: O(m * n)
// Space Complecity: O(m * n)

class Solution {
    int[][] dirs;
    int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        if(image[sr][sc] == color) return image;
        this.m = image.length;
        this.n = image[0].length;
        this.dirs = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        // System.out.println(m + " " + n + " " + dirs);
        //base
        if(sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] != oldColor) return;
        //logic
        image[sr][sc] = newColor;
        for(int[] dir : dirs) {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            dfs(image, nr, nc, oldColor, newColor);
        }
    }
}