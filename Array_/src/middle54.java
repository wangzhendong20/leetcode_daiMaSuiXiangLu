import java.util.ArrayList;
import java.util.List;

public class middle54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int loop = Math.min(m,n) / 2;
        int startx = 0,starty = 0;
        int i,j;
        int offset = 1;
        int mid = loop;

        while (loop-- > 0){
            i = startx;
            j = starty;
            for (j = starty; j < n - offset; j++) {
                res.add(matrix[startx][j]);
            }

            for (i = startx; i < m - offset; i++){
                res.add(matrix[i][j]);
            }

            for (; j > starty; j--){
                res.add(matrix[i][j]);
            }

            for (; i > startx; i--){
                res.add(matrix[i][j]);
            }

            startx++;
            starty++;
            offset++;
        }

        if (Math.min(m,n) % 2 == 1){
            if (m > n){
                for (int k = mid; k < mid + m - n + 1; k++) {
                    res.add(matrix[k][mid]);
                }
            }else {
                for (int k = mid; k < mid + n - m + 1; k++) {
                    res.add(matrix[mid][k]);
                }
            }

        }

        return res;
    }
}
