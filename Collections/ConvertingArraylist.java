import java.util.Arrays;
import java.util.LinkedList;

public class ConvertingArraylist {
    public static void main(String[] args) {
        String[] stuff = {"phone",  "notebook", "headphones", "driver", "display"};
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(stuff));
        list.add("knife");
        list.addFirst("lighter");

        stuff = list.toArray(new String[list.size()]);
        for (String string : list) {
            System.out.printf("%s ", string);
        }
    }
}
