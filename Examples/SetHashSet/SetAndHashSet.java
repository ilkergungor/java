import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class SetAndHashSet{
    public static void main(String[] args) {
        Set<String> numbers = new HashSet<>();

        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");
        numbers.add("five");

        System.out.println("HashSet\n");
        System.out.println(numbers);

        System.out.println("---------------------\n");
        System.out.println("forEach\n");
       
        numbers.forEach(System.out::println);
        
        System.out.println("---------------------\n");
        System.out.println("Iterator\n");

        Iterator<String> numbersIterator = numbers.iterator();
            while(numbersIterator.hasNext()){
                System.out.println(numbersIterator.next());
            }
        System.out.println("---------------------\n");
        System.out.println("for\n");

        for (String number: numbers){
           System.out.println(number);
        }
        System.out.println("---------------------\n");
        System.out.println("List\n");

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(2);
        numberList.add(1);

        System.out.println(numberList);
    
        System.out.println("---------------------\n");  
        System.out.println("HashSet\n");

        Set<Integer> numberSet = new HashSet<>();  
        numberSet.addAll(numberList);    // == new HashSet<>(numberList);

        System.out.println(numberSet);

        System.out.println("---------------------\n");  
        System.out.println("TreeSet\n");
    
    Set<String> numbersTree = new TreeSet();
       numbersTree.add("one");
        numbersTree.add("two");
        numbersTree.add("three");
        numbersTree.add("four");
        numbersTree.add("five");

        System.out.println(numbersTree);

        System.out.println("---------------------\n");  
        System.out.println("LinkedHashSet\n");  

        Set<String> numbersLinkHash = new LinkedHashSet();
        numbersLinkHash.add("one");
        numbersLinkHash.add("two");
        numbersLinkHash.add("three");
        numbersLinkHash.add("four");
        numbersLinkHash.add("five");

        System.out.println(numbersLinkHash);
    }
}
