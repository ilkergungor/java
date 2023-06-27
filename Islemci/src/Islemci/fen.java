package Islemci;

public class fen extends alt3 implements bil, ciz
	{
	public fen(String isim, int no)
	{
		super(isim, no);
	}
	public void bil() 
	{
		System.out.println("Bildim!");	
	}
	public void bolumSoyle() 
	{
		System.out.println("Benim bölümüm Fendir!");	
	}
	public void bilgisayardaYaz()
	{
		System.out.println("Hesapladım!");
	}
	public int bilgi(int a, int b)
	{
		return a/b*b;
	}
	public void cizgiCek()
	{
		System.out.println("Çizdim!");	
	}
}
