package StackAndQueue.MaxMatrix;

/**
 * Created by 10609 on 2017/3/31.
 */
public class MaxMatrix {
    private int row;
    private int col;
    private int zeroNum;
    private int[][] matrix;

    public MaxMatrix(int row, int col, int zeroNum) {
        this.row = row;
        this.col = col;
        this.zeroNum = zeroNum;
        generateMatrix();
        printMatrix();
    }


    private void generateMatrix() {
        matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 1;
            }
        }
        int zeros = getZeroNum();
        while (zeros > 0) {
            while (true) {
                int i = (int) (Math.random() * 1000000) % getRow();
                int j = (int) (Math.random() * 1000000) % getCol();
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                    break;
                }
            }
            zeros--;
        }
    }

    private boolean isFilled(int l1, int r1, int l2, int r2) {
        for (int i = l1; i <= l2; i++) {
            for (int j = r1; j <= r2; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getMaxMatrixGroupValue() {
        int maxVal = 0;
        for (int i = 0; i < row; i++) {
            for (int ii = 0; ii < i; ii++) {
                for (int j = 0; j < col; j++) {
                    for (int jj = 0; jj < j; jj++) {
                        if (isFilled(ii, jj, i, j)) {
                            int res = getMaxVal(ii, jj, i, j);
                            if (res > maxVal) {
                                maxVal = res;
                            }
                        }
                    }
                }
            }
        }
        return maxVal;
    }

    public void printMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setZeroNum(int zeroNum) {
        this.zeroNum = zeroNum;
    }


    private int getMaxVal(int l1, int r1, int l2, int r2) {
        return (l2 - l1 + 1) * (r2 - r1 + 1);
    }

    public int getZeroNum() {
        return zeroNum;
    }

    public static void test() {
        MaxMatrix maxMatrix = new MaxMatrix(4, 5, 4);
        int res = maxMatrix.getMaxMatrixGroupValue();
        System.out.println(res);
    }

    public static void main(String[] args) {
        test();
    }

}
