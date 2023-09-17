import java.util.PriorityQueue;
import java.util.Queue;

public class Qeueue {
    public static void main(String[] args) {
        
        Queue<String> q = new PriorityQueue<String>();
        q.offer("first");
        q.offer("second");
        q.offer("third");
        
        System.out.printf("%s ", q);
        System.out.println();

        System.out.printf("%s ", q.peek());     //Priority
        System.out.println();
        
        q.poll();                                               //Removes head of queue
        System.out.printf("%s ", q);
    }
}
