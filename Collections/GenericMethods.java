public class GenericMethods {
    public static void main(String[] args) {

        Integer[] intarray = {1, 2, 3, 4};
        Character[] charray = {'a', 'b', 'c', 'd', 'e'};

        printMe(intarray);
        printMe(charray);
    }
    /*public static void printMe(Integer[] i) {
        for (Integer integer : i) System.out.printf("%s ", i);
        System.err.println();
    }
    public static void printMe(Character[] c) {
        for (Character character : c) System.out.printf("%s ", c);
        System.out.println();
    }*/
    public static <T> void printMe (T[] t){    //Generic for any type data T is "Common" convention
        for (T x : t) System.out.printf("%s ", x);
        System.out.println();
    }
}
