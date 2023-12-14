import java.util.Deque;
import java.util.LinkedList;

public class middle200_bfs {
    int[][] dir = {
            {0,1},{1,0},{-1,0},{0,-1}
    };
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    bfs(grid,visited,i,j);
                }
            }
        }
        return ans;
    }

    private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{x,y});
        visited[x][y] = true;
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int m = cur[0];
            int n = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextx = m + dir[i][0];
                int nexty = n + dir[i][1];
                if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
                if (!visited[nextx][nexty] && grid[nextx][nexty] == '1') {
                    deque.offer(new int[]{nextx,nexty});
                    visited[nextx][nexty] = true;
                }
            }
        }
    }
}
