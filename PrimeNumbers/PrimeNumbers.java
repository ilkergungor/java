import java.util.Scanner;

public class PrimeNumbers {
    /*public static final */ int n = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the last number: ");
        int n = scanner.nextInt();
        scanner.close();

        System.out.println("Prime numbers between 1 and " + n + " are: ");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

