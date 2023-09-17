/**
 * Multithreading
 */
public class Multithreading {

    public static void main(String[] args) {
        for(int i = 1; i < 3; i++){
            MultiThing first = new MultiThing(i);
            Thread theThread = new Thread(first);
            theThread.start();
            try {
                theThread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
              theThread.isAlive();
        }
        throw new RuntimeException();
    }
}