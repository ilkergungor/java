package Islemci;

public class od
{
	public static void main(String[] args)
{
	alt3 o1 = new mat("Ali", 4);		//mat ve fen alt3'ün extend'i olduğu için en başa al3 yazıldı
	alt3 o2 = new fen("Ayşe", 5);		//Interface'e de ait olduğu belirtilebilir, ama alttakilerde değiştirilmelidir
	alt3 o3 = new psi("Veli", 7);
	
	o1.adSoyle();
	o2.adSoyle();	
	o3.adSoyle();

	((mat) o1).hesapla();		//o1 alt3 objesi olduğu için parantezle mat olduğunu belirtmek gerekir
	((fen) o2).bil();

	o1.bolumSoyle();
	o2.bolumSoyle();
	o3.bolumSoyle();

	((mat) o1).bilgisayardaYaz();
	((fen) o2).bilgisayardaYaz();
	((psi) o3).bilgisayardaYaz();
	
	((fen) o2).cizgiCek();
	((psi) o3).cizgiCek();
	
	}
} 
