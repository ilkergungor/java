package QuestionAnswer;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		QuestionDemo qd = new QuestionDemo();
		frame.add(qd);
		frame.setVisible(true);
		frame.setBounds(540, 220, 600, 150);
	}
}