public class Lambdas {
    public static void main(String[] args) {        
        Cat mycat = new Cat();
        mycat.print("first", "second");

        Printable lambdaPrintable = (a, b) -> {System.out.println("Text: " +a +  b); return "returnText";};
        printThing(lambdaPrintable);
    }
    static void printThing(Printable thing){
        thing.print("This is A. ", "This is B.");
    }
}
