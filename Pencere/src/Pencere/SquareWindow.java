package Pencere;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SquareWindow extends JFrame implements ActionListener{

	int x, y;
	int w, h;
	
	public SquareWindow(){
			super();		//Class extend ettiği için costructor'da üst class'ı çağırmalıdır 
			x=20; y=20;
			w=50; h=50;
			
			Timer t = new Timer(200, this);
			t.start();			//t zaman parametresi her 40 ms'de 1 yineleyecek
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(x, y, w, h);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		x++;
		y++;
		repaint();
	}
}