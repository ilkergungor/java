package Dene3;

public class Cls {

	int [] list;
	int s;
	int x;
	
	public Cls (int c) {
		
		list = new int[c];
		s=0;
		x=c;
	}
	public void add( int n) {
		
		if (s < x)
		{
			list[s] = n;
			s++;
		}
		else
		{
			System.out.println("List is full!");	
		}
	}
	
	public void write()
	{
		for (int i = 0; i < s; i++)
		{
			System.out.println(list[i]);
		}	
	}
	
	public int max;
	{
		int b = list[0];
		
		for (int i = 0; i < s; i++)
		{
			if (list[i] > 0)
			{
				b = list[i];
			}
		}
	//	return b;	
	}
	
	public int min;
	{
		int k = list[0];
		
		for (int i = 0; i < s; i++)
		{
			if (list[i] < 0)
			{
				k = list[i];
			}
		}
//		return k;	
	}
	
	public void swap (int i1, int i2)
	{
		int tmp = list[i1];
		list[i1] = list[i2];
		list[i2] = tmp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
