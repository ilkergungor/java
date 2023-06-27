package Islemci;

public class islemci {

	public static void main(String[] args) {

		alt1 a1 = new alt1 (1);
		alt1 a2 = new alt1 (2);
		
		alt2 b1 = new alt2 (3);
		alt2 b2 = new alt2 (4);

		islem i1 = new islem (5);
		
		System.out.println(a1.islemYap(2,3));
		System.out.println(a2.islemYap(4,5));
		System.out.println(b1.islemYap(6,7));
		System.out.println(b2.islemYap(8,9));
		System.out.println(i1.islemYap(10, 11));			
	}		
}
