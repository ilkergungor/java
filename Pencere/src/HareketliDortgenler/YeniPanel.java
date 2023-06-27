package HareketliDortgenler;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;
import javax.swing.JPanel;
import java.util.Random;

public class YeniPanel extends JPanel implements ActionListener, MouseListener{
	
	Dortgen[] digerdortgenler;
	int adim=5;
	int elemanSayisi = 5;
	Timer zaman;
	Random random = new Random();
	
	public YeniPanel()
	{
		super();
	
		digerdortgenler = new Dortgen[50];
		digerdortgenler[0] = new Dortgen(10, 10, 20, 20,random.nextInt(10), random.nextInt(10));
		digerdortgenler[1] = new Dortgen(50, 50, 20, 20, random.nextInt(10), random.nextInt(10));
		digerdortgenler[2] = new Dortgen(100, 100, 20, 20, random.nextInt(10), random.nextInt(10));
		digerdortgenler[3] = new Dortgen(150, 150, 20, 20, random.nextInt(10), random.nextInt(10));
		digerdortgenler[4] = new Dortgen(200, 200, 20, 20, random.nextInt(10), random.nextInt(10));
		
		addMouseListener(this);
		zaman = new Timer(40, this);
		zaman.start();
	}
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawRect(0, 0, 1300, 740);		
		for(int i=0; i < elemanSayisi; i++)
		{
			digerdortgenler[i].ekranaCiz(g);
		}
	}

	public void actionPerformed(ActionEvent e) {
	
		for(int i=0; i < elemanSayisi; i++)
		{
			digerdortgenler[i].hareketEt(digerdortgenler, elemanSayisi);	
		}
		repaint();
	}

	public void mouseClicked(MouseEvent e) {

	}
	public void mousePressed(MouseEvent e) {
		digerdortgenler[elemanSayisi] = new Dortgen(e.getX(), e.getY(), 20, 20, random.nextInt(10), random.nextInt(10));
		elemanSayisi++;
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
