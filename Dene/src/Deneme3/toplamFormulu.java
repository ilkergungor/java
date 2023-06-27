package Deneme3;
import java.util.Scanner;
public class toplamFormulu {
	public static void main(String[] args) {
		int x;	
		Scanner a = new Scanner(System.in);
		System.out.println("Lütfen son sayıyı giriniz: ");	
		x = a.nextInt();				
		System.out.println(	"Toplam sonuç: " +(x*(x+1)/2));
	}		
}
