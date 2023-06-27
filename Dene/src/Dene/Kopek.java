package Dene;

public class Kopek extends Hayvan {
	
		int uykuSaati;
		int hiz;
		
	public Kopek(String isim, int yas, String renk, int uykuSaati, int hiz)
	{
		super(isim, yas, renk);
		this.uykuSaati = uykuSaati;
		this.hiz = hiz;	
	}
	public void sesCikar()
	{
	 System.out.println("Hav, ben " + yas + " yaşındayım.");
	}
}