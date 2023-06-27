package Deneme3;

import java.util.*;

public class Deneme {

	public static void main(String[] args) {

		Scanner tara= new Scanner(System.in);
		System.out.println("Bir sayı giriniz: ");
		int n = tara.nextInt();
		
	if(n%3==0)
		n*=3;

	else n/=2;
	System.out.println("n değeri: " + n);
	}

}
