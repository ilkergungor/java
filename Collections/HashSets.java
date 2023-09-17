import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSets {
    public static void main(String[] args) {
        
        String[] numbers = {"one", "two", "three", "three", "four", "five"} ;
        List<String> list = Arrays.asList(numbers);
    
        System.out.printf("%s ", list);
        System.out.println();

        Set<String> set = new HashSet<String>(list);        //Removes duplicates
        System.out.printf("%s ", set);
    }
}
