package Menu;

import java.util.Scanner;

public class menuyap {
	
	public static void main(String args[])	{	
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Lütfen bir sayı girin:");
		
		menuGoster();
	}
	public static void menuGoster()
		{
		int x=0;		
		Scanner scan = new Scanner(System.in);
		
		scan.nextInt();
			
		
	while (x!=4) 
	{
						
			System.out.println("1. Ara");
			System.out.println("2. Kaydet");
			System.out.println("3. Yükle");
			System.out.println("4. Çıkış");
			System.out.print("Seçenek: ");
			
			x= scan.nextInt();
			if(x==1)
				{
				System.out.println("Arama işlemi yapıldı...");
				}	
				else if (x==2)	
				{
					System.out.println("Kayıt işlemi yapıldı...");
				}
				else if (x==3)	
				{
					System.out.println("Yükleme işlemi yapıldı...");
				}
				else if (x==4)	
				{
					System.out.println("Programdan kapatıldı...");
				}	
				else	
				{
					System.out.println("Yalnış giriş yapıldı...");
				}
					
			}
		}
}
