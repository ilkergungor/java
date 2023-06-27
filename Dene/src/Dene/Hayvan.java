 package Dene;

public class Hayvan {
	
		String isim;
		int yas;
		String renk;

	public Hayvan(String isim, int yas, String renk) //Constructor class ile aynı isimde olur
	{		
		this.isim = isim;		//yukarıdaki isime karşılık gelmesi için this. kullanılır
		this.yas = yas;			//yukarıdaki yaşa karşılık gelmesi için this. kullanılır	
		this.renk = renk;
	}
	public void yuru()
	{	
		System.out.println("Yürüdüm.");
	}
	public void yasSoyle()
	{	
	
		System.out.println("Yaşım:" + yas);
	}
	public void sesCikar()
	{	
		System.out.println("Ben bir hayvanım.");
	}
	public int islem(int a, int b)
	{
		return a*(b+3);	
	}
}