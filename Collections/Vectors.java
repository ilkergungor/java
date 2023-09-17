import java.util.Vector;

public class Vectors {
    public static void main(String[] args) {

        Vector<String> v = new Vector<>(4, 2);
        System.out.println("Capacity: " + v.capacity());
        System.out.println("Size : " +v.size());
        v.add("newObject1");
        v.add("newObject2");
        v.add("newObject3");
        v.add("newObject4");
        v.add("newObject5");
        v.add("newObject6");
        v.add("newObject7");
        v.add("newObject8");
        v.add("newObject9");
        v.add("newObject10");
        v.add("newObject11");
        System.out.println(v.firstElement());
        System.out.println("Capacity: " + v.capacity());
        System.out.println("Size : " +v.size());
        System.out.println(v);
        v.forEach(i -> System.out.println(i));
    }
}

