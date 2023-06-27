package Ders2;
import java.util.Scanner;

public class fibonacci {

/*	public static void main(String[] args)
    {
        int n = 30; // Number of terms to print
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci(i, memo) + " ");
        }
    }
 
    public static int fibonacci(int n, int[] memo)
    {
        if (memo[n] != 0)
            return memo[n];
        if (n == 1 || n == 2)
            return 1;
        else {
            memo[n] = fibonacci(n - 1, memo)
                      + fibonacci(n - 2, memo);
            return memo[n];
        }
    }
}*/
public static void main(String[] args) {
    int n = 30; // Fibonacci serisinin kaç terimini yazdırmak istediğinizi belirleyin
    int[] fibonacci = new int[n];
    
    fibonacci[0] = 0; // İlk terim 0
    fibonacci[1] = 1; // İkinci terim 1
    
    for (int i = 2; i < n; i++) {
        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]; // Fibonacci serisi hesaplama formülü
        
    }
    
    System.out.println("Fibonacci Serisi:");
    for (int i = 0; i < n; i++) {
        System.out.print(fibonacci[i] + " ");
    }
}
}
