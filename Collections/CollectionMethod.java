import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionMethod {
    public static void main(String[] args) {
        String[] crap = {"apples", "lemons", "peaches", "grapes"};
        List<String> l1 = Arrays.asList(crap);
        
        Collections.sort(l1);
            System.out.printf("%s\n", l1);
        Collections.sort(l1, Collections.reverseOrder());
            System.out.printf("%s\n", l1);

        Character[] array = {'k', 'f', 'y'};
        List<Character> l = Arrays.asList(array);
            System.out.println("List is : ");
            output(l);
        
        Collections.reverse(l);
            System.out.println("After reverse: ");
            output(l);

        Character[] charray =  new Character[3];
        List<Character> lc = Arrays.asList(charray);

        Collections.copy(lc, l);
            System.out.println("Copy of the list: ");
            output(lc);

        Collections.fill(l, 'X');
            System.out.println("After filling the list: ");
            output(l);
    }
    private static void output(List<Character> list){
        for (Character character : list) {
            System.out.printf("%s", character);
        }
        System.out.println();
    }
}
