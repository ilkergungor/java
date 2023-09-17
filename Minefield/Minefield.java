import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Minefield implements MouseListener {
	JFrame frame;
	Buttons[][] board = new Buttons[10][10];
	int openButton;

	public Minefield() {
		openButton = 0;
		frame = new JFrame("Minefield");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(10, 10));

		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				Buttons b = new Buttons(row, column);
				frame.add(b);
				b.addMouseListener(this);
				board[row][column] = b;
			}
		}
		generateMine();
		updateCount();
		frame.setVisible(true);
	}
	public void generateMine() {
		int i = 0;
		while (i < 10) {
			int randomRow = (int) (Math.random() * board.length);
			int randomColumn = (int) (Math.random() * board[0].length);

			while (board[randomRow][randomColumn].isMine()) {
				randomRow = (int) (Math.random() * board.length);
				randomColumn = (int) (Math.random() * board[0].length);
			}
			board[randomRow][randomColumn].setMine(true);
			i++;
		}
	}
	public void print() {
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				if (board[row][column].isMine()) {
					board[row][column].setIcon(new ImageIcon("mine.png"));
				} else {
					board[row][column].setText(board[row][column].getCount() + "");
					board[row][column].setEnabled(false);
				}
			}
		}
	}
	public void printMine() {
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				if (board[row][column].isMine()) {
					board[row][column].setIcon(new ImageIcon("mine.png"));
				}
			}
		}
	}
	public void updateCount() {
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				if (board[row][column].isMine()) {
					counting(row, column);
				}
			}
		}
	}
	public void counting(int row, int column) {
		for (int i = row - 1; i <= row + 1; i++) {
			for (int k = column - 1; k <= column + 1; k++) {
				try {
					int value = board[i][k].getCount();
					board[i][k].setCount(++value);
				} catch (Exception e) {}
			}
		}
	}
	public void open(int r, int c) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length ||
        board[r][c].getText().length() > 0 || board[r][c].isEnabled() == false) {
			return;
		} else if (board[r][c].getCount() != 0) {
			board[r][c].setText(board[r][c].getCount() + "");
			board[r][c].setEnabled(false);
			openButton++;
		} else {
			openButton++;
			board[r][c].setEnabled(false);
			open(r - 1, c);
			open(r + 1, c);
			open(r, c - 1);
			open(r, c + 1);
		}
	}
	public void mouseClicked(MouseEvent e) {
		Buttons b = (Buttons) e.getComponent();
		if (e.getButton() == 1) {
			if (b.isMine()) {
				JOptionPane.showMessageDialog(frame, "Game Over!");
				print();
			} else {
				open(b.getRow(), b.getColumn());
				if (openButton == (board.length * board[0].length) - 10) {
					JOptionPane.showMessageDialog(frame, "Congrats!");
					print();
				}
			}
		} else if (e.getButton() == 3) {
			if (!b.isFlag()) {
				b.setIcon(new ImageIcon("flag.png"));
				b.setFlag(true);
			} else {
				b.setIcon(null);
				b.setFlag(false);
			}
		}
	}
	public void mouseEntered(MouseEvent arg0) {}
    public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
