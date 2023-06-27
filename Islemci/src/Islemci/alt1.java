package Islemci;

public class alt1 extends islem{
		
		public alt1(int x)
		{
		super (x);
		}
		public int islemYap(int q, int w) //Üst class'taki islemYap metodu Override edilmiş oldu
		{
		int sonuc = super.islemYap(q, w); 		 
			System.out.println("Toplam sonuç: a*(b+3)+a+b=" + sonuc);
			return sonuc + q + w;	      //Bu sonucu vermesi için
		}
}


