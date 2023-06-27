package Dene;

public class HayvanDene {

	public static void main(String[] args)
	{
		Hayvan h1 = new Hayvan("boğa", 30, "siyah");
		Hayvan h2 = new Hayvan("boğa", 24, "siyah");
		
		Kedi k1 = new Kedi("Tekir", 7, "sarı",  "Makarna");
		Kedi k2 = new Kedi("Scottish", 4, "gri",  "Somon");
		k1.yuru();
	//  k.yas= 19; 
		System.out.println("----------------------");		
		Kopek p1 = new Kopek("Doberman", 6, "siyah", 8, 10);
		p1.yuru();
	//  p.yas= 12;
		System.out.println("----------------------");
		h1.yasSoyle();
		h2.yasSoyle();
		k1.yasSoyle();
		p1.yasSoyle();
		System.out.println("----------------------");
		k1.sesCikar();
		p1.sesCikar();
		System.out.println("----------------------");		
		k2.kediyeOzel();
		System.out.println("----------------------");	
		k1.islem(3,6);
		System.out.println(k1.islem(3,6));
		p1.islem(3,6);
		System.out.println(k1.islem(3,7));
		p1.islem(3,6);
		System.out.println(k1.islem(3,9));	
	}
}
