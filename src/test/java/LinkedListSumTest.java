import org.junit.Test;
public class LinkedListSumTest {

    @Test
    public void testSum1() {
        LinkedListSum.Node sum = new LinkedListSum().calculateSum(new int[]{2,4,6}, new int[]{9,3,5});
        sum.print();
    }

    @Test
    public void testSum2() {
        LinkedListSum.Node sum = new LinkedListSum().calculateSum(new int[]{6}, new int[]{5});
        sum.print();
    }

}