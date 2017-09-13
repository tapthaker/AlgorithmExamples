import java.util.ArrayList;

/**
 * Created by Tapan on 9/3/2017.
 */
public class CombinationOfArray {

  ArrayList<int[]> findCombinations(int[][] arrays) {
    ArrayList<int[]> combinations = new ArrayList<int[]>();
    printCombination(arrays, 0, "");
    return combinations;
  }

  void printCombination(int[][] array, int arrayIndex, String generatedCombination) {

    if (arrayIndex == array.length) {
      System.out.println(generatedCombination);
      return;
    }

    for (int i = 0; i < array[arrayIndex].length; i++) {
      printCombination(array, arrayIndex + 1,
          generatedCombination + array[arrayIndex][i]);
    }
  }
}
