
public class AllSubSetsOfASet {

    void printSubSets(int array[]) {
        int n = array.length;
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(array[j] + " ");
                }
            }
            System.out.print("}");
            System.out.println();
        }
    }
}