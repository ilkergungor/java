import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {

        String[] arr = new String[4];      
        String[] array = {"Chris", "John", "Mike", "Tom"};

        ArrayList<Integer> primitives = new ArrayList<>();
        ArrayList<String> arraylist = new ArrayList<>();
        ArrayList<String> arraylist2 = new ArrayList<>(Arrays.asList("Chris", "John", "Mike", "Tom"));

        System.out.println(array[1]);
        System.out.println(arraylist2.get(3));
        System.out.println(arr.length);
        System.out.println(arraylist2.size());
        arraylist2.add("Carl");
        System.out.println(arraylist2.get(4));
        array[0] = "Karen";
        System.out.println(array[0]);
        arraylist2.set(2, "Kevin"); 
        System.out.println(arraylist2.get(2));
        arraylist2.remove(1); 
        System.out.println(arraylist2);
    }
}