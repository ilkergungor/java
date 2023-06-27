package Dikdortgen;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Dortgen {

	Rectangle r;
	
	public Dortgen(int x, int y, int w, int h)
	{
		r = new Rectangle(x, y, w, h);		//r objesi Dortgen class'ına ait bir dörtgeni tanımladı		
	}
	public void ekranaCiz(Graphics g)
	{
		g.drawRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
	}
	
	public void hareketET(int x, int y, Dortgen[] digerdortgenler, int sayi)	//Kareler birbirie değmesin diye array'in parametreleri ve sayisi eklendi
	{
		Rectangle gecici = new Rectangle(r);
		gecici.setLocation((int)gecici.getX()+x, (int)gecici.getY()+y);			//Geçici rectangle'a hareketEt metodu uygulanır ve yürüme değişikliği yapıldı
																				
		boolean cakisma = false;												//Çakışma olup olmayacağı boolean ile tespit edilecek
			for(int i=0; i < sayi; i++)
				{
				if(gecici.intersects(digerdortgenler[i].getRectangle()))	//Eğer ikisi eşitse çakışma var olacak ve boolean
					{cakisma = true;}				
				}
			if(gecici.getX() < 0 || gecici.getY() < 0 || gecici.getX() > 1280 || gecici.getY() > 720) //Hareket eden karenin ekran sınırları içerisinde kalmasını sağlar
				cakisma = true;
				if(cakisma == false)
		r.setLocation((int)r.getX()+x, (int)r.getY()+y);	//r ekseninin x ve y'yi parametrelere ekler
	}
	
	public Rectangle getRectangle()
	{
		return r;											//digerdortgenler[i]'ye ait Rectangle'ı gönderdmek için	get metodu kullanıldı
	}	
}
