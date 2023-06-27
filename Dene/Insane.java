package Dene;

public class Insane {

	private int yas;
	private String isim;
	
	public Insane (int alinanYas, String alinanIsim)
	{
		yas=alinanYas;
		isim=alinanIsim;
		}
	
	public void biriniSelamla(Insane gelenInsan)
	{
		System.out.println("Merhaba, " + gelenInsan.getIsim() + " benim adım " + getIsim()
				+ ". Nasılsın?");
	}
	
	
	public void sayiSay(int baslangic, int son)
	{
		int sayi=baslangic;

		
		while (sayi<=son)
		{
			
			System.out.println(sayi);
			sayi= sayi+1;
		}
			
	}
	
	public void sayiSay2(int baslangic, int son)
	{
		int sayi=baslangic;

		
		while (sayi<=son)
		{
			
			System.out.println(sayi);
			sayi= sayi+2;
		}
			
	}
	
	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}
}
