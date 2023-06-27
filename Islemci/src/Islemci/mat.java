package Islemci;

public class mat extends alt3 implements bil
	{
	public mat(String isim, int no)
	{
		super(isim, no);
	}
	public void hesapla() 
	{
		System.out.println("Hesapladım!");
	}

	public void bolumSoyle() 
	{		
		System.out.println("Benim bölümüm Matematiktir!");
	}
	public void bilgisayardaYaz()
	{
		System.out.println("Yazdım!");
	}
	public int bilgi(int a, int b)
	{
		return a*b+b*2;
	}
}
