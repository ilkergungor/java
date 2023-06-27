package Pencere;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ornek extends JFrame implements MouseListener{

	JLabel label1, label2, label3;
	JPanel panel1;
	
	int sayi = 0; 				//Sayıyı artırıp azaltabilmek için gereklidir
	
	public Ornek()					//JFrame'den oluşturabilmek için bir constructor olmak zorundadır
	 	{
		 super();
		 
		 panel1 = new JPanel();
		 add(panel1);									//JFrame'e JPanel'i eklemek için
		
		 label1 = new JLabel("Merhaba!");				//add metodu constructor'da olmak zorundadır
		 panel1.add(label1);							//Label'ı JPanel'e eklemek için. 
		 												//JFrame olursa sadece add olmalı ama diğeri gözükmez
		 label2 = new JLabel("Güle güle!");
		 panel1.add(label2);
		 
		 label3 = new JLabel(" " + sayi);
		 panel1.add(label3);	
		 
		 
	 	 addMouseListener(this);
	 	}		 
	 		public static void main(String[] args)
	 		{	
			Ornek pencere = new Ornek();
			pencere.setSize(640, 480);						
			pencere.setVisible(true);		
	 		}
			public void mouseClicked(MouseEvent e) {
				
			if(e.getButton() == MouseEvent.BUTTON1)
			{
				sayi++;
			}	
			else if (e.getButton() == MouseEvent.BUTTON3)
			{
				sayi--;	
			}
			label3.setText("" + sayi);					//repaint'i otomatik yapıyor
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
}
