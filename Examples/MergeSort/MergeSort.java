import java.util.Random;

public class MergeSort {
public static void main(String[] args) {        
    Random random = new Random();
    int[] numbers = new int[10];

    for(int i = 0; i < numbers.length; i++){
        numbers[i] = random.nextInt(1000000);
    }
    System.out.println("Before: ");
    printArray(numbers);

    mergeSort(numbers);

    System.out.println("\nAfter: ");
    printArray(numbers);
}
   private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;
        if(inputLength < 2){
            return;
        }
        int middleIndex = inputLength / 2;
        int[] leftHalf = new int[middleIndex];      
        int[] rightHalf = new int[inputLength - middleIndex];   
        
        for(int i = 0; i <middleIndex; i++){
            leftHalf[i] = inputArray[i];
        }
        for(int i = middleIndex; i <inputLength; i++){
            rightHalf[i - middleIndex] = inputArray[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(inputArray, leftHalf, rightHalf);
   }
    private static void merge(int[] inputArray,int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;

        while(i < leftSize && j < rightSize){
            if(leftHalf[i] <= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            }else{
                inputArray[k] = rightHalf[j];
                j++;
           }
           k++;
        }
        while(i < leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while(j < rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }
   private static void printArray(int[] numbers) {
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }
}
