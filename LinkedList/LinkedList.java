public class LinkedList{

public static void main(String[] args) {
    List list = new List();

    list.addEnd(14);
    list.addIndex(44, 0); 
    list.addEnd(10);
    list.addFront(2);
    list.addFront(6);
    list.addEnd(14);
    list.addFront(4);
    list.removeFront();
    list.addFront(6);
    list.addEnd(14);
    list.addFront(8);
    list.writeList();

    System.out.println();

        
    list.addEnd(14);
    list.addEnd(16);
    list.removeIndex(0);
    list.addEnd(14);
    list.removeFront();
    list.addEnd(12);
    list.removeEnd();
    list.removeNumber(10);
    list.addEnd(10);
    list.removeAllSameNumbers(6);
    list.addIndex(106, 20); 
    list.addIndex(35, 7);
    list.addEnd(14);
    list.writeList();
    list.removeAllSameNumbers(14);
    list.writeList();
}
}