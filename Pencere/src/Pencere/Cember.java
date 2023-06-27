package Pencere;

import java.awt.Graphics;

public class Cember {

	int x, y;
	int w;								//Çember olacağı için tek parametre 
										//yeterli, oval olsaydı h de olurdu
	
	
	public Cember(int x, int y, int w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}
	
	public void ekranaCiz(Graphics g)
	{
		g.drawOval(x, y, w, w);
	}

	public void genisle(int i)
	{
		w = w + i;
		x = x - (i/2);
		y = y - (i/2);	
}
}
