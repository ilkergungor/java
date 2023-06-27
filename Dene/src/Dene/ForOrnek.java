package Dene;

public class ForOrnek {

	public static void main(String[] args) {


	PazarListesi liste = new PazarListesi(5);
	liste.listeyeEkle("Ekmek");
	liste.listeyeEkle("Su");
	liste.listeyeEkle("Süt");
	
	liste.yaz();
	
	}

}
