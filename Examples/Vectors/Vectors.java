import java.util.*;

public class Vectors {
    public static void main(String[] args){
        int size = 1000000;
        
        List <Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();

        for(int i = 0; i < size; i++){
           arrayList.add(i); 
        }
        long end = System.currentTimeMillis();
        System.out.println(size + "          " + (end - start));

        List<Integer> vector = new Vector<>();
         start = System.currentTimeMillis();

        for(int i = 0; i < size; i++){
           vector.add(i); 
        }
        end = System.currentTimeMillis();
        System.out.println(size + "          " + (end - start));


        List<Integer> threadedList = Collections.synchronizedList(new ArrayList<>());
        start = System.currentTimeMillis();

        Thread t1 = new Thread(() ->{
            for(int i = 0; i < size; i++){
                threadedList.add(i); 
            }
        });
        Thread t2 = new Thread(() ->{
            for(int i = 0; i < size; i++){
                threadedList.add(i); 
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        end = System.currentTimeMillis();
        System.out.println(size + "          " + (end - start));

        List<Integer> threadedvector = new Vector<>();
        start = System.currentTimeMillis();
        
        t1.start();
        t2.start();
         t1 = new Thread(() ->{
            for(int i = 0; i < size; i++){
                threadedvector.add(i); 
            }
        });
                t2 = new Thread(() ->{
            for(int i = 0; i < size; i++){
                threadedvector.add(i); 
            }
        });
        end = System.currentTimeMillis();
        System.out.println(size + "          " + (end - start));
    }
}
