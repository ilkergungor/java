package Dene;

import java.util.Scanner;

public class SayiTahminiDoWhile {
	
public static void main(String args[])
{
	int cevap = 20;
	int girdi = 0;
		
	boolean oyunDevam = false;
	
	Scanner sc = new Scanner(System.in);
	
	do
	{
		oyunDevam=true;
		
			System.out.print("Bir sayı giriniz:");
		
		girdi = sc.nextInt();
		
		if (girdi > cevap)
				{
			
			System.out.println("Tahminini küçült!");
			
				}
		
		else if (girdi < cevap)
		{
		
			System.out.println("Tahminini büyült!");
			
		}
		else if (girdi == cevap)
		{
			
			System.out.println("Tebrikler bildiniz! Oyun Bitti!");
			oyunDevam = false;
			
		}

	}
	while(oyunDevam);		
		
}
}