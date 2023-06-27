package Dikdortgen;

import javax.swing.JFrame;

public class Dikdortgen {

	public static void main(String[] args) {

		
		JFrame pencere = new JFrame("Program");
		Pencere panel1 = new Pencere();				
		pencere.add(panel1);						
		pencere.addKeyListener(panel1);				
		pencere.setSize(1280, 720);						
		pencere.setVisible(true);	
	}
}



