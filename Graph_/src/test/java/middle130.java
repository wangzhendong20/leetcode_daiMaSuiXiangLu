public class middle130 {

    int[][] dir = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };

    private void dfs(char[][] board ,int x,int y) {
        board[x][y] = 'A';
        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nextx >= board.length || nexty < 0 || nexty >= board[0].length) continue;
            if (board[nextx][nexty] == 'X' || board[nextx][nexty] == 'A') continue;
            dfs(board,nextx,nexty);
        }
        return;
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board,i,0);
            if (board[i][n-1] == 'O') dfs(board,i,n-1);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board,0,j);
            if (board[m-1][j] == 'O') dfs(board,m-1,j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }
}
