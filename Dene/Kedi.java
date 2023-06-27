package Dene;

public class Kedi extends Hayvan 
{	
	String mamaTuru;
	
	public Kedi(String isim, int yas, String renk, String mamaTuru)
	{
		super(isim, yas, renk);
		this.mamaTuru = mamaTuru;	//Super constructor'ın önünde olamaz
	}	
	public void sesCikar()		//Extend edilen Hayvan class'ında olmasına rağmen override edilmiştir
	{
		super.sesCikar();		//Extend edilen class'tan metod çağırmaya yarar
	 System.out.println("Miyav, ben " + yas + " yaşındayım.");
 	} 
	public void kediyeOzel()
	{
	 System.out.println("Kediye Özel!");
	}
}
