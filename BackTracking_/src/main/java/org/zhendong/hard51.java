package org.zhendong;

import java.util.ArrayList;
import java.util.List;

public class hard51 {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }
        backtracing(n,0,board);
        return res;
    }

    private void backtracing(int n, int row, char[][] board) {
        if (row == n) {
            res.add(Array2List(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, board, n)) {
                board[row][col] = 'Q';
                backtracing(n,row+1,board);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] board, int n) {

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> Array2List(char[][] board) {

        List<String> list = new ArrayList<>();
        for (char[] chars : board) {
            list.add(String.copyValueOf(chars));
        }
        return list;
    }
}
