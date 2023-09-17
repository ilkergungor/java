import java.util.HashSet;
import java.util.Iterator;

public class Hashes {
    public static void main(String[] args) {

        HashSet<String> h = new HashSet<String>();
        h.add("abcde");
        h.add("qwerty");
        h.add("abc");
        h.add(" xzy");

        System.out.println(h);
        System.out.println(h.size());
        System.out.println(h.isEmpty());
        System.out.println(h.contains("abc"));
        System.out.println(h.contains("abcd"));
        
        h.clear();
        System.out.println(h);

        System.out.println("\n----------------------------\n");

        HashSet<Integer> i = new HashSet<Integer>();
        i.add(1);
        i.add(3);
        i.add(7);
        i.add(5);
        System.out.println(i);
        System.out.println(i.hashCode());

        Object[] a = i.toArray();
        System.out.println(a[0]);

        Iterator<Integer> it = i.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
