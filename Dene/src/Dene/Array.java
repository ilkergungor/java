package Dene;
import java.util.Scanner;
public class Array {
	
		public static void main(String[] args)
		{
		int[] a;				//Array tanımı 
		a = new int[10];		//Toplam array sayısı.	a[0], ... , a[9], (array 0'dan başlar)
		int i = 0;
		int sonuc = 0;			//girilen sayıları toplamak için
		
		Scanner sc = new Scanner(System.in);
		
		while(i<5)
		{		
		System.out.print((i + 1) + ". sayıyı girin: ");		//i=0 olduğu için, 1. sayıyı girin:den 5. sayıyı girin:e kadar yazar
		a[i] = sc.nextInt();								//girilen sayıyı okur
		i++;												//i'yi arttırmak için gereklidir, yoksa sürekli 0. sayıyı okur.
		}
			
		for(int x = 0; x < 5; x++) {
			
			sonuc = sonuc + a[x];							//0'dan 4'ekadar girilen tüm sayıları toplama formülü			
		}
		System.out.println("Sonuç = " + sonuc);	
		}	
		}
