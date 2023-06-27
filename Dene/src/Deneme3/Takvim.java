package Deneme3;
import java.util.Calendar;
import java.util.Date;
public class Takvim {

	public static void main(String[] args) {
		Calendar bugun = Calendar.getInstance();
		System.out.println("Yıl: " + bugun.get(Calendar.YEAR));
		System.out.println("Ay: " + (bugun.get(Calendar.MONTH)+1));
		System.out.println("Gün: " + bugun.get(Calendar.DATE));
		System.out.print("Saat: " + bugun.get(Calendar.HOUR));
		System.out.println(":" + bugun.get(Calendar.MINUTE));
		
	}

}
