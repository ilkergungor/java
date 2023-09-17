import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedLists {
    public static void main(String[] args) {

        String[] fruit = {"apple", "peach", "lemon", "grape"};
        List<String> list = new LinkedList<String>();
        for (String string : fruit)
            list.add(string);

        String[] veg = {"tomato", "potato", "pepper", "celery"};
        List<String> list2 = new LinkedList<String>();
        for (String string : veg)
            list2.add(string);

        list.addAll(list2);
        list2 = null;

        printMe(list);
        removeStuff(list, 2, 5);        //2 to 4
        printMe(list);
        reverseMe(list);
    }
    private static void printMe(List<String> l){
        for(String x : l){
            System.out.printf("%s ", x);
        }
        System.out.print("\n------------------------\n");
    }
    private static void removeStuff(List<String> l, int from, int to) {
        l.subList(from, to).clear();
    }
    private static void reverseMe(List<String> l) {
        ListIterator<String> lit = l.listIterator(l.size());
        while(lit.hasPrevious()){
            System.out.printf("%s ", lit.previous());
        }
        System.out.print("\n------------------------\n");
    }
}
