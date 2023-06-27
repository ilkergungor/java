package Dikdortgen;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Pencere extends JPanel implements KeyListener{
	
	Dortgen a;
	Dortgen[] digerdortgenler;
	int adim=5;
	int elemanSayisi = 5;
	
	public Pencere()
	{
		super();
		addKeyListener(this);
		a = new Dortgen(300, 300, 20, 20);
		digerdortgenler = new Dortgen[10];
		digerdortgenler[0] = new Dortgen(10, 10, 20, 20);
		digerdortgenler[1] = new Dortgen(50, 50, 20, 20);
		digerdortgenler[2] = new Dortgen(100, 100, 20, 20);
		digerdortgenler[3] = new Dortgen(150, 150, 20, 20);
		digerdortgenler[4] = new Dortgen(200, 200, 20, 20);
	}
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		a.ekranaCiz(g);		
		g.drawRect(0, 0, 1300, 740);		//Karenin gidebileceği max sınırlar
		for(int i=0; i < elemanSayisi; i++)
		{
			digerdortgenler[i].ekranaCiz(g);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(KeyEvent e) {
		
		System.out.println(e.getKeyCode());
	
			if(e.getKeyCode() == e.VK_UP)
			{
				a.hareketET(0,  -adim, digerdortgenler, elemanSayisi);
				repaint();
			}
			else if(e.getKeyCode() == e.VK_DOWN)
			{
				a.hareketET(0,  adim, digerdortgenler, elemanSayisi);	
				repaint();
			}
			else if(e.getKeyCode() == e.VK_LEFT)
			{
				a.hareketET(-adim, 0, digerdortgenler, elemanSayisi);	
				repaint();
			}
			else if(e.getKeyCode() == e.VK_RIGHT)
			{
				a.hareketET(adim,  0, digerdortgenler, elemanSayisi);		
				repaint();
			}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
