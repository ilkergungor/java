public class GenericReturn {
    public static void main(String[] args) {
        
    System.out.println(max(23, 42, 10));
    System.out.println(max("chicken", "apple,", "lemon"));
    }
    public static <T extends Comparable<T>> T max(T a, T b, T c) {
        
        T m = a;            //m was the maximum

        if(b.compareTo(a) > 0)
        m = b;

        if(c.compareTo(m) > 0)
        m = c;

        return m;
    }
}
