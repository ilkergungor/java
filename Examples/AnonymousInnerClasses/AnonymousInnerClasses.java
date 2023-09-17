public class AnonymousInnerClasses {
    public static void main(String[] args) {

        Animal myAnimal = new Animal();
        myAnimal.doneTask();

        Animal bigmouth = new Animal(){
            public void doneTask() {
                System.out.println("It's not done yet!");
            }
        };
        bigmouth.doneTask();

        Runnable myAnonymouseRunnable = new Runnable(){
            public void run() {
                System.out.println("Runnable print!");
            }
        };
        myAnonymouseRunnable.run();
    }
}
