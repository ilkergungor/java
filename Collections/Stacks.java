import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new  Stack<String>();
    
        stack.push("top");
        printStack(stack);
        stack.push("center");
        printStack(stack);
        stack.push("bottom");
        printStack(stack);

        stack.pop();
        printStack(stack);
        stack.pop();
        printStack(stack);
        stack.pop();
        printStack(stack);
        
    }
    private static    void printStack(Stack<String> stack){
        if(stack.isEmpty()) System.out.println("There is nothing in the stack");
        else System.out.printf("%s TOP\n", stack);
    }
}
