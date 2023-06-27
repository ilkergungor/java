package Ders;
import java.util.Scanner;
public class Ders {
	public static void main(String args[])
	{
		Scanner scan= new Scanner(System.in);
		System.out.println(carpbol(4,5,2));
	
	}
//	int sonuc = topla(3,4);
//	sonuc=sonuc*2;
//	System.out.println("Çarpım " + sonuc);
	//	yaz("Ali", "Yılmaz");}
//public static void yaz(String isim, String soyad)
//{
//	System.out.println("Merhaba " + isim+ " " + soyad + ".");
//}

/* public static int topla(int a, int b)
{
	int c = a+b;
	return c; 
}*/
public static int carpbol(int carpan, int carpilan, int bolen)
{
	return (carpan*carpilan)/ bolen;

}
}