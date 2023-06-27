package Dene;

import java.util.Scanner;

public class SayiTahmini {
	
public static void main(String args[])
{
	int cevap = 20;
	int girdi = 0;
		
	boolean oyunDevam = true;
	
	Scanner sc = new Scanner(System.in);
	
	while(oyunDevam) {
		
		System.out.print("Bİr sayı giriniz:");
		
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
}
}