package Islemci;

public abstract class alt3 {

	public alt3(String isim, int no)
	{							//Constructor
		//super();				//Şart değil çünkü class extend değil
		this.isim = isim;
		this.no = no;
	}	
	public void adSoyle() {
		System.out.println("Adım " + isim);
	}
	
	public abstract void bolumSoyle();		//Extend edilen ve abstract olmayan tüm class'lar  
											//metodlar bu bölümü doldurmak zorundadır	
	private String isim;
	private int no;
	
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
}
}

