import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Collections {
    public static void main(String[] args) {

        String[] things = {"egg", "apple", "lemon", "milk", "butter"};
        List<String> list = new ArrayList<String>();
            for (String string : things)
                list.add(string);
            for(int i = 0; i < list.size(); i++)
                System.out.printf("%s ", list.get(i));

        System.out.println("\n-------------------\n");

        String[] more = {"lemon" , "egg", "milk"};
        List<String> list2 = new ArrayList<String>();
            for (String string : more)
                list2.add(string);
            for(int i = 0; i < list2.size(); i++)
                System.out.printf("%s ", list2.get(i));

        editList(list, list2);
        System.out.println();

        for(int i = 0; i < list.size(); i++)
                System.out.printf("%s ", list.get(i));
    }
    public static void editList(Collection<String> l1, Collection<String> l2){
        Iterator<String> it = l1.iterator();
        while(it.hasNext()){
            if(l2.contains(it.next()))
                it.remove();
        }
    }
}
