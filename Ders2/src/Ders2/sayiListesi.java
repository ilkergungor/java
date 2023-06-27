package Ders2;

import java.security.PublicKey;

public class sayiListesi {
	int[] liste;
	int elemanSayisi;
	int sinir;											//Listenin sınırını bilmek için, constructor'daki kapasite bilgisinin tüm class'ta kullanabilmesi için tanımlandı
	public sayiListesi(int elemanKapasitesi) {			//constructor; dışarıdaki bir class'ın bu constructor'ı çağırarak listeyi oluşturması gerekiyor																								
		liste = new int[elemanKapasitesi];			
		elemanSayisi = 0;
		sinir = elemanKapasitesi;
	}	
	public void listeyeEkle(int eklenecekOlan)		//Listeye bir şey ekleme fonksiyonu
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
			System.out.print(liste[i] + " ");			
		}
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
	public void ekle(int eklenecekEleman, int index)	{		//Herhangi bir index'e eklemek için
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
	public int max()
	{
		int enBuyuk = liste[0];		
		for (int i=0; i < elemanSayisi; i++)
		{
			if (liste[i]>enBuyuk)		
			{
				enBuyuk = liste[i];	
			}
		}
		return enBuyuk;
	}
		public int min()
		{
			int enKucuk = liste[0];		
			for (int i=0; i < elemanSayisi; i++)
			{
				if (liste[i]<enKucuk)	
				{
					enKucuk = liste[i];		
				}
			}
			return enKucuk;
	}
		public void swap(int i1, int i2)	
		{		
			int tmp = liste[i1];								
			liste[i1] = liste[i2];
			liste[i2] = tmp;
		}
		public void selectionSort()
		{
			int enKucukIndex;
			int u=0;
			for(int i = 0; i < elemanSayisi; i++)
			{
			enKucukIndex = i;
				for (int j=i; j < elemanSayisi; j++)
				{
					if (liste[j] < liste[enKucukIndex])	
					{
						enKucukIndex = j;		
					}
			}
			swap(enKucukIndex, i);
			u++;
}
			System.out.println("Sort için toplam swap sayısı: " + u);
		}
			public void selectionSortTersten()
			{
				int enBuyukIndex;
				int t=0;
				for(int i = 0; i < elemanSayisi; i++)
				{
				enBuyukIndex = i;
					for (int j=i; j < elemanSayisi; j++)
					{
						if (liste[j] > liste[enBuyukIndex])	
						{
							enBuyukIndex = j;							
					}
				}
				swap(enBuyukIndex, i);
				t++;
				
				}	System.out.println("Sort tersten için toplam swap sayısı: " + t);
			}
				public void bubbleSort()
				{
					boolean swapped = true; 
					int s=0;
			
					while(swapped)
					{
						swapped = false;

						for (int i = 1; i<elemanSayisi; i++)
						{
							if (liste[i-1]>liste[i])
							{
							swap (i-1, i);
							swapped = true;
							s++;
							System.out.println();
							yaz();							
							}
						}
						System.out.println("Bubble sort için toplam swap sayısı: " + s);
				}	
}
}
