package HareketliDortgenler;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Dortgen {

	Rectangle r;

	int vX, vY;		//X ve Y koordinatlarının hızları
	
	public Dortgen(int x, int y, int w, int h, int vX, int vY)
	{
		r = new Rectangle(x, y, w, h);			
		this.vX = vX; 
		this.vY = vY;
	}
	public void ekranaCiz(Graphics g)
	{
		g.drawRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
	}
	
	public void hareketEt(Dortgen[] digerdortgenler, int sayi)
	{
		Rectangle gecici = new Rectangle(r);
		gecici.setLocation((int)gecici.getX()+vX, (int)gecici.getY()+vY);		
																				
		boolean cakisma = false;
		
			for(int i=0; i < sayi; i++)
				{
				if((!this.equals(digerdortgenler[i])) && gecici.intersects(digerdortgenler[i].getRectangle()))
					{cakisma = true;
					}				
				}
	if(gecici.getX() < 0 || gecici.getY() < 0 || gecici.getX() > 1280 - gecici.getWidth() || gecici.getY() > 720 - gecici.getHeight())
				{cakisma = true;}
			
				if(cakisma == false)
				{
					r.setLocation((int)r.getX()+vX, (int)r.getY()+vY);
				}
				else
				{
					vX = - vX;
					vY = - vY;
				}
	}					
	public Rectangle getRectangle()
	{
		return r;										
	}}

