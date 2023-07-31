public class middle59 {
    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int startx = 0,starty = 0;
        int loop = n/2;
        int mid = n/2;
        int count = 1;
        int offset = 1;
        int i,j;
        while (loop-- > 0){
            i = startx;
            j = starty;
            for (j = starty; j < n - offset; j++) {
                res[startx][j] = count++;
            }

            for (i = startx;  i < n - offset; i++) {
                res[i][j] = count++;
            }

            for (; j > starty; j--) {
                res[i][j] = count++;
            }

            for (; i > startx; i--){
                res[i][j] = count++;
            }

            startx++;
            starty++;
            offset++;
        }

        if (n % 2 == 1){
            res[mid][mid] = count;
        }

        return res;
    }
}
