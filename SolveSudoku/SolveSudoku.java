import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;

public class SolveSudoku extends JPanel{
    public static int[][] board = {
            {0, 8, 0, 0, 0, 4, 0, 5, 0},
            {0, 6, 0, 2, 0, 0, 0, 0, 0},
            {5, 0, 2, 0, 7, 0, 1, 0, 0},
            {0, 0, 6, 0, 0, 0, 0, 0, 0},
            {2, 0, 1, 9, 0, 0, 0, 4, 0},
            {0, 0, 0, 0, 8, 0, 0, 0, 9},
            {0, 0, 0, 0, 0, 3, 7, 0, 0},
            {4, 0, 9, 8, 0, 0, 0, 1, 0},
            {0, 5, 0, 0, 0, 0, 0, 0, 0},
            }; 
    private static final int GRID_SIZE = 9;
    public static void main(String[] args) throws InterruptedException {

        print(board);

        if (solve(board)){
            System.out.println("Solved");
        }else{
            System.out.println("Not solved!");
        }
        print(board);

        SolveSudoku s = new SolveSudoku();
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Sudoku");
         frame.add(s);
        frame.setVisible(true);
         frame.setSize(880, 880);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true){
            frame.repaint();
            Thread.sleep(100);
        }
    }
    private static void print(int[][] board) {
        for(int row = 0; row < GRID_SIZE; row++){
            if(row % 3 == 0  && row != 0){
                System.out.println("----------");
            }
            for(int column = 0; column < GRID_SIZE; column++){
                if(column % 3 == 0  && column != 0){
                System.out.print("|");
            }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }     
    }
    private static boolean isNumberInRow(int [][] board, int number, int row){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[row][i] == number){
                return true;
            }
        }
    return false;
    }
    private static boolean isNumberInColumn(int [][] board, int number, int column){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[i][column] == number){
                return true;
            }
        }
        return false;
    }
    private static boolean isNumberInBox(int [][] board, int number, int row, int column){
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;
        
        for(int i = localBoxRow; i < localBoxRow + 3; i++){
            for(int j = localBoxColumn; j < localBoxColumn + 3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isValidPlace(int[][] board, int number, int row, int column){
        return !isNumberInRow(board, number, row) &&
                   !isNumberInColumn(board, number, column) &&
                   !isNumberInBox(board, number, row, column);
    }
    private static boolean solve(int[][] board){
        for (int row = 0; row < GRID_SIZE; row++){
            for (int column = 0; column < GRID_SIZE; column++){
                if(board[row][column] == 0){
                    for (int tryNumber = 1; tryNumber <= GRID_SIZE; tryNumber++){
                        if(isValidPlace(board, tryNumber, row, column)){
                            board[row][column] = tryNumber;

                            if(solve(board)){       //recursive
                                return true;
                            }else{
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        for(int i = 0; i < GRID_SIZE; i++) {
            for(int j = 0; j < GRID_SIZE; j++) {
                g.drawString(" " + board[j][i],  80*(i+1), (80*(j+1)));
            }
        }
    }
}
