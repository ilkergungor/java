package Islemci;

public class psi extends alt3 implements bil, ciz
	{
	public psi(String isim, int no)
	{
		super(isim, no);
	}
	public void bolumSoyle() 
	{
		System.out.println("Benim bölümüm Psikolojidir!");
	}
	public void bilgisayardaYaz()
	{
		System.out.println("Okudum!");
	}
	public int bilgi(int a, int b)
	{
		return a-b;
	}
	public void cizgiCek()
	{
		System.out.println("Çizdim!");
	}
}
