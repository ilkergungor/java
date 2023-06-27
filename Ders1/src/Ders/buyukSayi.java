package Ders;

public class buyukSayi {
	static int buyuksayi;
	
	public static void main(String args[])
	{
		int x= hesapla(7,15);
		System.out.println("Büyük olan sayı: " + x);	
	}
	static int hesapla(int a, int b)
	{
		if (a>b)
			
		buyuksayi = a;
			
		else if(a<b)
			
		buyuksayi = b;
		
		return buyuksayi;
	}
		
	}
	



