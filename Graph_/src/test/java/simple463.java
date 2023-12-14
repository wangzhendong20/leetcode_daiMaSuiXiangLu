public class simple463 {
    public int islandPerimeter(int[][] grid) {
        int[][] dir = {
                {1,0},
                {0,1},
                {-1,0},
                {0,-1}
        };
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int[] pos : dir) {
                        int x = i + pos[0];
                        int y = j + pos[1];
                        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0){
                            ans++;
                            continue;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int islandPerimeter2(int[][] grid) {
        int sum = 0;    // 陆地数量
        int cover = 0;  // 相邻数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                    // 统计上边相邻陆地
                    if(i - 1 >= 0 && grid[i - 1][j] == 1) cover++;
                    // 统计左边相邻陆地
                    if(j - 1 >= 0 && grid[i][j - 1] == 1) cover++;
                    // 为什么没统计下边和右边？ 因为避免重复计算
                }
            }
        }
        return sum * 4 - cover * 2;
    }

}
