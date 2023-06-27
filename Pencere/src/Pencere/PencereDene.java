package Pencere;

import javax.swing.JFrame;

public class PencereDene {


	public static void main(String[] args) {

	/*	BizimPencere pencere = new BizimPencere();
		pencere.setSize(800, 600);
		pencere.setVisible(true);
				
		SquareWindow pencere = new SquareWindow();
		pencere.setSize(800, 600);
		pencere.setVisible(true);
		
		JFrame pencere = new JFrame("Program");
		pencere.add(new SuDalgasi());
		pencere.setSize(800, 600);
		pencere.setVisible(true);
		*/
		
		JFrame pencere = new JFrame("Program");
		CokluSuDalgasi panel1 = new CokluSuDalgasi();	//JPanel işlemini eklemek
		pencere.add(panel1);							//Oluşturulan JPanel'e klavye girişle
		pencere.addKeyListener(panel1);					//JPanel'de KeyListener çalışmadığı için 
		pencere.setSize(1280, 720);						//ayrı bir değişken olarak kullanıldı
		pencere.setVisible(true);	
	}
}
