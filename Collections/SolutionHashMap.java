import java.util.HashMap;
import java.util.Map;

public class SolutionHashMap {

    static int[] numbers = {5, 2, 4};
    int target = 6;
public static void main(String[] args) {
    System.out.println();
}
        public int[] twoSum(int[] numbers, int target) {
        
        Map<Integer, Integer> complements = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++){
            Integer complementIndex = complements.get(numbers[i]);
            if (complementIndex != null){
                return new int[]{i, complementIndex};
            }
            complements.put(target - numbers[i], i);
        }
        return numbers;
    }
}
