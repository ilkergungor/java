public class MultiArray {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12},
            {13, 14, 15}
        };

        for(int i =0; i < matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");

        for (int[] row : matrix) {
            for (int  value: row){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
