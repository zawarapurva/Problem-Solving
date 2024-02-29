// https://leetcode.com/problems/01-matrix/

// Time Complexity: O(m * n)
// Space Complecity: O(m * n)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0)
            return mat;

        int m = mat.length;
        int n = mat[0].length;
        // int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Queue<Integer> q = new LinkedList<>();

        // // Add cells with value 0 to the queue
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (mat[i][j] == 0) {
        //             q.add(i);
        //             q.add(j);
        //         } else {
        //             mat[i][j] = -1;
        //         }
        //     }
        // }

        // int dist = 1;

        // while (!q.isEmpty()) {
        //     int size = q.size() / 2;
        //     for (int i = 0; i < size; i++) {
        //         int sr = q.poll();
        //         int sc = q.poll();
        //         for (int[] dir : dirs) {
        //             int nr = dir[0] + sr;
        //             int nc = dir[1] + sc;
        //             if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {
        //                 q.add(nr);
        //                 q.add(nc);
        //                 mat[nr][nc] = dist;
        //             }
        //         }
        //     }
        //     dist++;
        // }

        // return mat;

        // Initialize the result matrix with maximum possible distance
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        // Iterate through the matrix and trigger DFS for cells with value 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dfs(mat, result, i, j, 0);
                }
            }
        }

        return result;
    }

    private void dfs(int[][] mat, int[][] result, int i, int j, int distance) {
        int m = mat.length;
        int n = mat[0].length;

        // Check boundaries and if the current distance is less than the recorded distance
        if (i < 0 || i >= m || j < 0 || j >= n || distance >= result[i][j]) {
            return;
        }

        // Update the result matrix with the minimum distance
        result[i][j] = distance;

        // Explore neighbors in all four directions
        dfs(mat, result, i + 1, j, distance + 1);
        dfs(mat, result, i - 1, j, distance + 1);
        dfs(mat, result, i, j + 1, distance + 1);
        dfs(mat, result, i, j - 1, distance + 1);
    }

}
