public class Generic<T> {
        T obj;

    public static void main(String[] args) {
        
        Generic <Integer> i = new Generic<Integer>(15);
        System.out.println(i.getObj());
    }
    public Generic(T obj) {
        this.obj = obj;
    }
    public T getObj(){
        return this.obj;
    }
}
