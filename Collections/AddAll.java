import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddAll {
    public static void main(String[] args) {
        
        String[] stuff = {"apples", "lemons", "peaches", "grapes"};
        List<String>list1 = Arrays.asList(stuff);

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("limes");
        list2.add("oranges");
        list2.add("plums");
        list2.add("plums");

        for (String string : list2) System.out.printf("%s ", string);
        System.out.println("\n----------------");
        
        Collections.addAll(list2, stuff);
        for (String string : list2) System.out.printf("%s ", string);

        System.out.println("\n" + Collections.frequency(list2, "limes"));
        System.out.println("\n" + Collections.frequency(list2, "plums"));

        boolean tof = Collections.disjoint(list1, list2);   //if returns true they have no elements
        System.out.println(tof);

        if(tof) System.out.println("They don't have any elements!");
        else System.out.println("They includes elements!");
    }
}
