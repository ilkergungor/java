package Deneme3;

public class SelectionSort {
	
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11, 75, 6, 45, 18, 34};
        
        System.out.println("Dizinin sıralanmadan önceki hali:");
        printArray(array);
        
        selectionSort(array);
        
        System.out.println("Dizinin sıralandıktan sonraki hali:");
        printArray(array);
    }
    
    public static void selectionSort(int[] array) {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
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
