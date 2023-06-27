
package Deneme3;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11, 75, 6, 45, 18, 34};

        System.out.println("Dizinin sıralanmadan önceki hali:");
        printArray(array);

        bubbleSort(array);

        System.out.println("Dizinin sıralandıktan sonraki hali:");
        printArray(array);
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}