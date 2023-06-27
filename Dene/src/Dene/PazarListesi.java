package Dene;

public class PazarListesi {

	String[] liste;
	int elemanSayisi;
	int sinir;											//Listenin sınırını bilmek için
	
	public PazarListesi(int elemanKapasitesi) {			//constructor

		liste = new String[elemanKapasitesi];
		elemanSayisi = 0;
		sinir = elemanKapasitesi;
	}
	
	public void listeyeEkle(String eklenecekOlan){		//Listeye bir şey ekleme fonksiyonu
	
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
		
		for(int i = 0; i < elemanSayisi; i++)
		{	
			System.out.println(liste[i]);			
		}
		
	}
}

