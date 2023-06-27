package Dene;

import java.util.Scanner;

public class Selamla {

	public static void main(String args[])
	{
		Insane i1=new Insane(21, "Ali");
		Insane i2=new Insane(30,"Ahmet");
	
		Bisiklet b1 = new Bisiklet();
		
		
		Scanner scan =new Scanner(System.in);
		
		int a, b;
		
		System.out.print("Başlangıç değeri: ");
		a = scan.nextInt();
		System.out.print("Son değer: ");
		b = scan.nextInt();	
		
		i1.sayiSay(a,b);
		//i1.sayiSay2(a,b);
		
		
		
	/*	
	 *  b1.in();
		b1.bin(i1);
		b1.bin(i2);
		b1.in();
		b1.bin(i2);
		
		System.out.println("isim: " + i1.getIsim() +" " + " yaş: " + i1.getYas());
		System.out.println("isim: " + i2.getIsim() +" " + " yaş: " + i2.getYas());
		
		i1.biriniSelamla(i2);
		i2.biriniSelamla(i1);
		*/
	}
}
