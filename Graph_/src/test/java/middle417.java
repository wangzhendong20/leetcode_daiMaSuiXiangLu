import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class middle417 {

    int[][] dir = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] isPac = new boolean[m][n];
        boolean[][] isAtl = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights,isPac,i,0);
            dfs(heights,isAtl,i,n-1);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights,isPac,0,i);
            dfs(heights,isAtl,m-1,i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isPac[i][j] && isAtl[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, boolean[][] visited, int x, int y) {
        if (visited[x][y]) return;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nextx >= heights.length || nexty < 0 || nexty >= heights[0].length) continue;
            if (heights[x][y] > heights[nextx][nexty]) continue;
            dfs(heights,visited,nextx,nexty);
        }
    }


}
