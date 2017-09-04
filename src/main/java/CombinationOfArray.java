import java.util.ArrayList;

/**
 * Created by Tapan on 9/3/2017.
 */
public class CombinationOfArray {

    ArrayList<int[]> findCombinations(int[][] arrays) {
        ArrayList<int[]> combinations = new ArrayList<int[]>();
        int numberOfArrays = arrays.length;
        int maxNumberOfElements = findMaxNumberOfElements(arrays);
        for (int i = 0; i < maxNumberOfElements; i++) {
            System.out.print("[");
            for (int j = 0; j < numberOfArrays; j++) {
                if (i < arrays[j].length) {
                    System.out.print(arrays[j][i] + " ");
                }
            }
            System.out.println("]");
        }


        return combinations;
    }

    int findMaxNumberOfElements(int[][] arrays) {
        int max = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > max) {
                max = arrays[i].length;
            }
        }
        return max;
    }

}
