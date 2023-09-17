import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {

        List<Integer>list = new ArrayList<>();
        list.add(12354345);
        printList(list);

        List<No>nlist = new ArrayList<>();
        nlist.add(new No());
        printList(nlist);

        Printer<Integer> printer = new Printer<>(23);
        printer.print();

        Printer<Double> doublePrinter = new Printer<>(3.14);
        doublePrinter.print();

        Printer<No> nn = new Printer<>(new No());
        printer.print();

        ArrayList<No> nos = new ArrayList<>();
        nos.add(new No());

        ArrayList<Object> object = new ArrayList<>();
        nos.add(new No());

        No n1 = nos.get(0);

        shout(100);
        shout(new No());
        tnV("firstT", "secondV");
    }
    public static <T> void shout(T thingToPrint) {
        System.out.println(thingToPrint + "-------------");
    }
        public static <T, V> void tnV(T thingToPrint, V otherThingToPrint) {
        System.out.println(thingToPrint + "-------------" + otherThingToPrint);
    }
    private static void printList(List<?> list) {       //"?" is Wild Card
        System.out.println(list);
    }
}
