import java.util.HashMap;
import java.util.Map;

public class MapsAndHM {
    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<Integer, String>();
        m.put(1, "a");
        m.put(2, "b");
        m.put(4, "c");
        m.put(3, "d");
        System.out.println(m);
        m.remove(3);
        
        System.out.println(m.isEmpty());
        System.out.println(m.size());
        System.out.println(m.keySet());
        System.out.println(m.values());
        System.out.println(m.containsKey(1));
        m.replace(4, "e");
        System.out.println(m);
        System.out.println("----------------------");
        for (Map.Entry k : m.entrySet()) System.out.print(k.getKey() + " " + k.getValue()+ ", ");
            
        System.out.println("\n" + m.containsValue("d"));
        m.clear();
        System.out.println(m.isEmpty());
        System.out.println(m);
    }
}
