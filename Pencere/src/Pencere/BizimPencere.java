package Pencere;

import java.util.Random;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class BizimPencere extends JFrame implements MouseListener, KeyListener{
	
	private String text;
	private Random rnd;
	
	private int x1, y1, x2, y2;
	
	public BizimPencere() {	
		super();									//JFrame'den pencere işlemlerini 
		rnd = new Random();							//gözardı etmesin, direkt alsın diye
			addMouseListener(this);					//this = bulunduğu class'da harekete geçmesi için
			addKeyListener(this);
		
		x1 = 0; y1 = 0;	x2 = 0;	y2 = 0;
		text = "Hello!";
}	
	public void paint(Graphics g) {
		super.paint(g); 							//Pencerenin kendi halini çağırır
		g.drawLine(x1, y1, x2, y2);
		g.drawString(text, x1, y1);					//Yazının başlayacağı pikseller
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == e.BUTTON1) {
		x1 = e.getX();
		y1 = e.getY();								//Ekran içeriğinin yeniden çizilmesini sağlar
		repaint();
		}
		else if (e.getButton() == e.BUTTON2) {
		x2 = e.getX();								//Ekran içeriğinin yeniden çizilmesini sağlar
		y2 = e.getY();
		repaint();
		}
		else if (e.getButton() == e.BUTTON3) {
		x2 = e.getX();								//Ekran içeriğinin yeniden çizilmesini sağlar
		y2 = e.getY();
		repaint();
		}
			}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == e.BUTTON1) {
		x1 = e.getX();
		y1 = e.getY();
		repaint();
		}
		else if (e.getButton() == e.BUTTON2) {
		x2 = e.getX();
		y2 = e.getY();
		repaint();
		}
		else if (e.getButton() == e.BUTTON3) {
		x2 = e.getX();
		y2 = e.getY();
		repaint();
	}
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
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	if(e.getKeyCode() == e.VK_BACK_SPACE && text.length() > 0){		//Backspace tuşuna silme komutunu verdi
	text = text.substring(0, text.length()-1);	//Yazıdan karakter kesmeye yarar.
	}
	else {
		text += e.getKeyChar();	}	//Tuşa basılı tutulduğunda çok yazmayı engeller tek harf yazar
	repaint();	}
	public void keyReleased(KeyEvent e) {

		
		// TODO Auto-generated method stub
		
	}
}