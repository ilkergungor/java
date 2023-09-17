public class Enum {
    public static void main(String[] args) {
      DaysOfTheWeek days = DaysOfTheWeek.thursday;

        if(days == DaysOfTheWeek.thursday){
            System.out.println("Today is thursday!");
        }
        for(DaysOfTheWeek theDay : DaysOfTheWeek.values()){
        System.out.println(theDay);
        }
        System.out.println( Snacks.DORITOS.levelOfDeliciousness);
    }
}
