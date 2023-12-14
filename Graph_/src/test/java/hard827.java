import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class hard827 {
    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 四个方向

    /**
     * @param grid 矩阵数组
     * @param row 当前遍历的节点的行号
     * @param col 当前遍历的节点的列号
     * @param mark 当前区域的标记
     * @return 返回当前区域内 1 的数量
     */
    public static int dfs(int[][] grid, int row, int col, int mark) {
        int count = 0;
        grid[row][col] = mark;
        for (int[] pos : position) {
            int x = row + pos[0];
            int y = col + pos[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) continue;
            if (grid[x][y] == 1) {
                count += 1 + dfs(grid,x,y,mark);
            }
        }
        return count;
    }

    public static int largestIsland(int[][] grid) {
        int ans = Integer.MIN_VALUE, size = grid.length, mark = 2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j, mark) + 1;
                    map.put(mark++, count);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != 0) continue;
                HashSet<Integer> set = new HashSet<>();
                int curSize = 1;
                for (int[] pos : position) {
                    int x = i + pos[0];
                    int y = j + pos[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) continue;
                    int curMark = grid[x][y];
                    if (set.contains(curMark) || !map.containsKey(curMark)) continue;
                    set.add(curMark);
                    curSize += map.get(curMark);
                }
                ans = Math.max(ans, curSize);
            }
        }
        if (Integer.compare(ans, Integer.MIN_VALUE) == 0) ans = size * size;
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0}, {0, 1}};
        int ans = largestIsland(grid);
        System.out.println(ans);
    }
}
