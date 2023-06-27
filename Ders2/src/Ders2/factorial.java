package Ders2;
import java.util.Scanner;
public class factorial
{
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Bir sayı girin: ");
	        int sayi = scanner.nextInt();
	        
	        long faktoriyel = faktoriyelHesapla(sayi);
	        System.out.println(sayi + "! = " + faktoriyel);
	    }
	    
	    public static long faktoriyelHesapla(int sayi) {
	        long faktoriyel = 1;
	        
	        for (int i = 1; i <= sayi; i++) {
	            faktoriyel *= i;
	        }
	        
	        return faktoriyel;
	    }
	    }

