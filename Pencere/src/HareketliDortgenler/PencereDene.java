package HareketliDortgenler;

import javax.swing.JFrame;

public class PencereDene {

	public static void main(String[] args) {

		
		JFrame pencere = new JFrame("Program");
		YeniPanel panel1 = new YeniPanel();				
		pencere.add(panel1);				
		pencere.setSize(1280, 720);						
		pencere.setVisible(true);	
	}
}




