public class largestbinary {
    public static void main(String args[]) {
        int mat[][] = {{0, 1}, {0, 0}, {0, 0}};
        int row = 3, col = 2;

        int a = row * col - 1;
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    res += Math.pow(2, a);
                    a--;
                }
            }
        }

        System.out.println(res % 100000007);

    }
}
