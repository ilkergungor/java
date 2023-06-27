package Alti;

public class Insan
{
	private int yas;
	private String isim;
	private String uyruk;
	private String sehir;
	
	/*public Insan()
	{
		setYas(999);
		setIsim("isimsiz");
	}*/
	
	public Insan(int alinanYas, String alinanIsim, String alinanUyruk, String alinanSehir)
	{
	setYas(alinanYas);
	setIsim(alinanIsim);
	setSehir(alinanSehir);
	setUyruk(alinanUyruk);
	
	}

	public void selamla()
	{
		System.out.println("Merhaba, benim adım " + getIsim());
	}
	
	public void biriniSelamla(Insan gelenInsan)
	{
		System.out.println("Merhaba, " + gelenInsan.getIsim() + " benim adım " + isim
				+ ". Nasılsın?");
	}
	
	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public String getUyruk() {
		return uyruk;
	}

	public void setUyruk(String uyruk) {
		this.uyruk = uyruk;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}
	
	
}



