import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import javafx.scene.paint.Color;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

public class sss extends JPanel {

   
    public String board;
    private static final int GRID_SIZE = 9;
    public static void main(String[] args) {
        int[][] board = {
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
        print(board);
        sss s = new sss();
        if (solve(board)){
            System.out.println("Solved");
        }else{
            System.out.println("Not solved!");
        }
        print(board);

            ().add(panel);

    int row = MazeCreator.r;
    int col = MazeCreator.c;

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 500, 500);
    panel.setLayout(new GridLayout(row, col));

    JLabel[][] grid= new JLabel[row][column];
    for (int i = 0; i < row; i++){
        for (int j = 0; j < col; j++){
            board[i][j] = new JLabel();
            board[i][j].setBorder(new LineBorder(Color.BLACK));
            //grid[i][j].setBackground(Color.black);
            board[i][j].setOpaque(true);
            panel.add(board[i][j]);
        }
    }
        board[0][0].setBackground(Color.red);

        

        
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
        g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
        g.drawString(" " + board, 30, 30);
    }
}
