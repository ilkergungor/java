package Pencere;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SuDalgasi extends JPanel implements ActionListener, MouseListener{

	int x, y;
	int w, h;
	int increase = 1;						//Artış miktarı daha hızlı hareket etmesi için
	
	public SuDalgasi(){
			super();						//Class extend ettiği için costructor'da üst class'ı çağırmalıdır 
			x=100; y=100;
			w=200; h=200;
			
			addMouseListener(this);			//this = bulunduğu class'da harekete geçmesi için

			Timer t = new Timer(40, this);
			t.start();						//t zaman parametresi her 40 ms'de 1 yineleyecek
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(x, y, w, h);
	}

	public void actionPerformed(ActionEvent e) {

		x = x - (increase/2);
		y = y - (increase/2);
		w+= increase;
		h+= increase;
		repaint();
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {

		x = e.getX() - (w/2);				//Tıklanan yerin merkezi olması için yarısı kadar olmalı
		y = e.getY() - (h/2);
		h =0 ;w = 0;						//Yeni çember 0'dan başlasın diye
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
