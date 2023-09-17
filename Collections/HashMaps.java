import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMaps {
    public static void main(String[] args) {
        
        int a = 1;
        int b = 2;
        int c = 3;

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("a", 1);
        hm.put("b", 2);
        hm.put("c", 3);

        System.out.println(hm);
        System.out.println(hm.get("a"));
        System.out.println(hm.size());

        HashMap<String, String> x = new HashMap<>();
        x.put("abcde", "12345");
        x.put("qwerty", "9876");
        x.put("username", "password");
        x.put("remove", "this");

        Set s = x.entrySet();
        java.util.Iterator i = s.iterator();
        while(i.hasNext()) {Map.Entry item = (Map.Entry) i.next();
        System.out.println(item.getKey() +"===" + item.getValue());}

        System.out.println(x.containsValue("remove"));
        System.out.println(x.containsKey("remove"));    //Key is 1st
        System.out.println(x.containsValue("this"));        //Value is 2nd

        x.remove("remove", "this");
        System.out.println(x);

        System.out.println(x.containsValue("this"));
        x.replace("abcde", "54321");        //12345  is replaced to 54321
        
        System.out.println(x);

        System.out.println(x.keySet());      //Key is 1st
        System.out.println(x.values());      //Value is 2nd
    }
}
