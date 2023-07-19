import java.util.Random;
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
    list.addIndex(0, 5);
    list.removeFront();
    list.addFront(0);
    list.addEnd(14);
    list.addFront(8);
    list.writeList();     
    list.addEnd(14);
    list.addEnd(16);
    list.removeIndex(0);
    list.addEnd(-94);
    list.removeFront();
    list.addEnd(-147);
    list.removeNumber(10);
    list.addEnd(104);
    list.removeAllSameNumbers(6);
    list.addIndex(106, 20); 
    list.addIndex(-5, 7);
    list.addEnd(0);
    list.writeList();
    list.removeAllSameNumbers(14);
    list.writeList();
    list.bubbleSort();
    list.writeList();
    list.addSequent(79);
    list.writeList();
    //list.removeList();
    Random r = new Random();
    int rnd;
    for(int i = 0; i < 10; i++){
        rnd = r.nextInt(200);   
        System.out.println(rnd + " number is added.");
        list.stackPush(rnd);
        list.writeList();
            if(i %3 == 0){
            System.out.println(list.stackPop() + " number is removed.");
            list.writeList();
        }
    }
    while(list.isItFull()){
    System.out.println(list.stackPop() + " number is removed."); 
    list.writeList();
    }
    for(int i = 0; i < 10; i++){
        rnd = r.nextInt(200);   
        System.out.println(rnd + " queue is added.");
        list.queuePush(rnd);
        list.writeList();
            if(i %3 == 0){
            System.out.println(list.queuePop() + " queue is removed.");
            list.writeList();
        }
    }
    while(list.isItFull()){
    System.out.println(list.queuePop() + " queue is removed."); 
    list.writeList();
    }
}
}
