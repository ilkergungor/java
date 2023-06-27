package Pazar;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
				

	PazarListesi liste = new PazarListesi(10);
	
	liste.listeyeEkle("Ekmek");
	liste.listeyeEkle("Su");
	liste.listeyeEkle("Süt");
	liste.listeyeEkle("Yağ");
	liste.listeyeEkle("Un");

	
	System.out.println("İlk hali;");
	liste.yaz();
	
	/*System.out.println("Silmek istediğiniz sırayı girin: ");
	int a =	scan.nextInt();
	liste.sil(a);

	System.out.println("Eklemek istediğiniz sırayı girin: ");
	int a =	scan.nextInt();
	System.out.println("Eklemek istediğiniz ürünü girin: ");
	String b =	scan.next();
	
	liste.ekle(b, a);
	
	
	System.out.println("Son hali;");
	liste.yaz(); */

	System.out.println(liste.max());
	System.out.println(liste.min());
	}
}
