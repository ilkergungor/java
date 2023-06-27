package CheckBoxP;

import java.awt.Checkbox;
import javax.swing.JFrame;

public class Program {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.add(new CheckBoxPanel());
		frame.setVisible(true);
		frame.setBounds(540, 220, 600, 600);	//Pencerenin x,y koordinatları ve pikseli

	}

}
