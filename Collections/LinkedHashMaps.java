import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LinkedHashMaps {
    public static void main(String[] args) {
        System.out.println("------- Linked Hash Map ------");
        LinkedHashMap lhm = new LinkedHashMap();

        lhm.put("one", 1);
        lhm.put("two", 2);
        lhm.put("three", 3);
        lhm.put("four", 4);

        Set s = lhm.entrySet();
        Iterator i = s.iterator();
        while(i.hasNext()){
            Map.Entry item = (Map.Entry)i.next();
            System.out.println(item.getKey() + " = " + item.getValue());
        }
        System.out.println("------- Hash Map ------");

        HashMap hm = new HashMap();
        hm.put("one", 1);
        hm.put("two", 2);
        hm.put("three", 3);
        hm.put("four", 4);

        Set sh = hm.entrySet();
        Iterator ih = sh.iterator();
        
        while(ih.hasNext()){
            Map.Entry itemh = (Map.Entry)ih.next();
            System.out.println(itemh.getKey() + " = " + itemh.getValue());
        }
        System.out.println("------- Tree Map ------");

        TreeMap tm = new TreeMap();
        tm.put("one", 1);
        tm.put("two", 2);
        tm.put("three", 3);
        tm.put("four", 4);

        Set st = tm.entrySet();
        Iterator it = st.iterator();

        while(it.hasNext()){
            Map.Entry itemt = (Map.Entry)it.next();
            System.out.println(itemt.getKey() + " = " + itemt.getValue());
        }
    }
}
