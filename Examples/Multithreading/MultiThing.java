public class MultiThing  implements Runnable {

    private int threadNumber;

    public MultiThing(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 3; i++){
            System.out.println(i + "thread number" + threadNumber);
            if(threadNumber == 3){
                throw new RuntimeException();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }        // TODO Auto-generated method stub
       
    }
}
