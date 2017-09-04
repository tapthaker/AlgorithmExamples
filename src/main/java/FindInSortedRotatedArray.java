/**
 * Created by Tapan on 9/3/2017.
 */
public class FindInSortedRotatedArray {
    int leftIndex;
    int rightIndex;

    int find(int [] array, int element) {
        leftIndex = 0;
        rightIndex = array.length - 1;

        while (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (array[middleIndex] == element) {
                return middleIndex;
            }

            if (array[middleIndex] > array[leftIndex]) {
                if (element < array[middleIndex] && element >= array[leftIndex]) {
                    rightIndex = middleIndex - 1;
                } else {
                    leftIndex = middleIndex + 1;
                }
            } else {
                if (element < array[middleIndex] && element >= array[rightIndex]) {
                    leftIndex = middleIndex + 1;
                } else {
                    rightIndex = middleIndex - 1;
                }
            }
        }

        return  -1;
    }


}
