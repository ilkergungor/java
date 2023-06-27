package Islemci;

public class islem {
	
	int x;

	public islem( int x)
	{
		this.x = x;	
	}
	public int islemYap(int a, int b)
	{
		System.out.println("a x (b+3)= " + a+ "*" + (b+3));
		return a*(b+3);	
	}
}
