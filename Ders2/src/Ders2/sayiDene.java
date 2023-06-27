package Ders2;

public class sayiDene {

	public static void main(String[] args) {

		sayiListesi liste = new sayiListesi(12);
		liste.ekle(5,0);
		liste.ekle(2,0);
		liste.ekle(11,0);
		liste.ekle(1,0);
		liste.ekle(7,0);
		liste.ekle(10,0);
		liste.ekle(9,0);
		liste.ekle(4,0);
		liste.ekle(6,0);
		liste.ekle(8,0);
		liste.ekle(3,0);
		liste.ekle(12,0);
		
		liste.yaz();
		
		liste.selectionSort();
		System.out.println();
		liste.yaz();
		
		liste.selectionSortTersten();
		System.out.println();
		liste.yaz();
		
		liste.bubbleSort();
		System.out.println();
		liste.yaz();
	}
}

