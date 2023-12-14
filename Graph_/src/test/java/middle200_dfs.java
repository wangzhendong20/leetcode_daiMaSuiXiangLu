public class middle200_dfs {
    int[][] dir = {
        {0,1},{1,0},{-1,0},{0,-1}
    };
    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
            if (!visited[nextx][nexty] && grid[nextx][nexty] == '1') {
                visited[nextx][nexty] = true;
                dfs(grid,visited,nextx,nexty);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    ans++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return ans;
    }

    private void dfs2(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') return;
        grid[x][y] = '0';
        dfs2(grid,x+1,y);
        dfs2(grid,x-1,y);
        dfs2(grid,x,y+1);
        dfs2(grid,x,y-1);
    }

    public int numIslands2(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs2(grid,i,j);
                }
            }
        }
        return ans;
    }
}
