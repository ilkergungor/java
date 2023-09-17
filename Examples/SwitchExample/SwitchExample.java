public class SwitchExample {
    public static void main(String[] args) {
        int day = 4;
        
        switch(day) {
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("Çarşamba");
                break;
            case 4:
                System.out.println("Perşembe");
                break;
            case 5:
                System.out.println("Cuma");
                break;
            default:
                System.out.println("Hafta içi değil");
        }
        
        int num = 15;
        
        switch(num) {
            case 10:
                System.out.println("10'a eşit");
                break;
            case 15:
                System.out.println("15'e eşit");
                break;
            case 20:
                System.out.println("20'ye eşit");
                break;
            default:
                System.out.println("Diğer değerler");
        }       
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue; // 5'i atlayıp döngünün bir sonraki adımına geçer
            }
            System.out.println(i);
        }
        
        String str = "Merhaba";
        
        if (str instanceof String) {
            System.out.println("str bir String nesnesidir");
        }
    }
}
/*Bu örnekte, switch ifadesi içinde day ve num değişkenlerine bağlı olarak farklı durumları kontrol ediyoruz.

Her durum için bir case ifadesi belirtiyoruz ve her case bloğunun sonunda break ifadesi kullanarak durumlar arasında

geçişi sağlıyoruz. default ifadesi, hiçbir case ifadesine uymayan durumlar için çalışır.

Ayrıca, continue ifadesini bir döngü içinde kullanarak, belirli bir koşulu sağlayan adımları atlamamızı sağlıyoruz.

Örneğin, i değeri 5 olduğunda döngünün bir sonraki adımına geçiyoruz.

Son olarak, instanceof ifadesini kullanarak bir nesnenin belirli bir türde olup olmadığını kontrol ediyoruz.

Eğer str değişkeni bir String nesnesi ise ilgili ifadeyi çalıştırıyoruz.

Bu basit örnekte, Java'da switch, case, break, continue ve instanceof ifadelerini kullanarak programın akışını kontrol

edebilirsiniz. Tabii ki, gerçek projelerde bu ifadelerin daha karmaşık senaryolarda nasıl kullanıldığını görmek mümkündür.
*/
