package Pazar;

public class PazarListesi {

	String[] liste;
	int elemanSayisi;
	int sinir;											//Listenin sınırını bilmek için, constructor'daki kapasite 
														//bilgisinin tüm class'ta kullanabilmesi için tanımlandı
	public PazarListesi(int elemanKapasitesi) {		
														//constructor; dışarıdaki bir class'ın bu constructor'ı 											
		liste = new String[elemanKapasitesi];			//çağırarak listeyi oluşturması gerekiyor
		elemanSayisi = 0;
		sinir = elemanKapasitesi;
	}
	
	public void listeyeEkle(String eklenecekOlan)		//Listeye bir şey ekleme fonksiyonu
		{
		if (elemanSayisi < sinir)
			{			
			liste[elemanSayisi] = eklenecekOlan;
			elemanSayisi++;		
			}
			else
			{
				System.out.println("Liste doldu!");
			}
		}	
	public void yaz() {
		
		for(int i = 0; i < elemanSayisi; i++)	//Eleman sayısı 0'dan büyükse yazdırılır
		{	
			System.out.println(liste[i]);			
		}
	}	
	public void sondanSil() {
		if(elemanSayisi > 0) 
		{		
			elemanSayisi--;						//Eleman sayısını bir azaltmaya yarar, böylece son eleman silinmiş olur
			liste[elemanSayisi] ="";			
		}
		
		else 
		{
			System.out.println("Zaten liste boş.");
		}
	}
	public void bastanSil()						//Baştaki eleman silinirken kaydırma işlemi yapılır 2>1, 3>2. liste[0]=""; yazmaya gerek yok
	 {	
		
	for(int i = 0; i < elemanSayisi-1; i++)		//Döngüde maksimum sayı 5 olduğundan, formülün 5.yi 6.ya eşitlemesini engellemek için
	{
		liste[i] = liste[i+1];
	}	
	elemanSayisi--;								//Elemanlar sondan başa kaydırıldığı için eleman sayısının bu formülle 1 azaltılması gerekir
	}	
	

	public void sil(int index)							//Silmek istenilen herhangi bir int index'indeki elemanı silmeye yarayacağı için index'e ihtiyaç olacaktır
	{
		if(index > 0 && index <= index-1)
		for(int i = index; i < elemanSayisi-1; i++)		//i=index silmeye başlanacak elemanın numarasını almak için
		{
			liste[i] = liste[i+1];
		}
		
		elemanSayisi--;									//Sonuncu eleman silinmek isteniyorsa for döngüsüne ihtiyaç duyulmadan eleman sayısı sondanSil gibi 1 azaltılır
}
	
	public void ekle(String eklenecekEleman, int index)	{		//Herhangi bir index'e eklemek için
	
			if(index <= elemanSayisi && elemanSayisi  < sinir)		
			{
		for(int i = elemanSayisi-1; i >= index; i--)			//index'ten itibaren elemanları 1 sağa kaydırmaya sondan yani ters yönde başlamak için i eS-1 oldu
		{														//böylece i sondan index'e kadar (i--) azalarak gidecektir
			liste[i+1] = liste[i];
		}
		liste[index] = eklenecekEleman;							//İstenilen index'e eklenecekEleman'ın yerleştirilmesi için yer açılır
		
		elemanSayisi++;	}
			else 
			{
				System.out.println("Yanlış index");
			}
	}
	public String max()
	{
		String enBuyuk = liste[0];
		
		for (int i=0; i < elemanSayisi; i++)
		{
			if (liste[i].compareToIgnoreCase(enBuyuk) > 0)		//String dizisinde obje []. nokta ile gösterilir
			{
				enBuyuk = liste[i];		//enBuyuk'ten daha büyük bir değer olunca yeni enBüyük o olur
			}
		}
		return enBuyuk;
	}
		public String min()
		{
			String enKucuk = liste[0];
			
			for (int i=0; i < elemanSayisi; i++)
			{
				if (liste[i].compareToIgnoreCase(enKucuk) < 0)		//String dizisinde obje []. nokta ile gösterilir
				{
					enKucuk = liste[i];		//enKucuk'ten daha küçük bir değer olunca yeni enKucuk olur
				}
			}
			return enKucuk;
	}
		public void swap(int i1, int i2)		//iki eleman yer değiştirilirken geçici bir temp elemana ihtiyaç duyulur
		{		
			String tmp = liste[i1];									//çünkü i1=i2 olduğunda 2. satırdaki i1  zaten i2'ye eşitlenecek
			liste[i1] = liste[i2];
			liste[i2] = tmp;
		}
	
}










