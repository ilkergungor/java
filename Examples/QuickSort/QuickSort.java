import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(100);
        }
        System.out.println("Before: ");
        printArray(numbers);

        quickSort(numbers);

        System.out.println("\nAfter: ");
        printArray(numbers);
    }
    private static void quickSort(int[] array) {        //overload
        quickSort(array, 0, array.length - 1);
    }
    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
          return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;    
        int pivot = array[pivotIndex];       // random pivot
        swap(array, pivotIndex, highIndex);
    
        int leftPointer = partition(array, lowIndex, highIndex, pivot);
    
        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }
    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        
        while(leftPointer < rightPointer){
            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(array[rightPointer] >= pivot && leftPointer < rightPointer ){
                rightPointer--;
            }
        swap(array, leftPointer, rightPointer);
        }
        if(array[leftPointer] > array[highIndex]) {
            swap(array, leftPointer, highIndex);     
        }else {
            leftPointer = highIndex;
        }
        return leftPointer;
    }
    private static void swap(int[] array, int index1, int index2){
        int temporary = array[index1];
        array[index1] = array[index2];
        array[index2] = temporary;
    }
    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
