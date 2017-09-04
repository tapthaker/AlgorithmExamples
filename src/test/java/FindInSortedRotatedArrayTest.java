import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindInSortedRotatedArrayTest {
    @Test
    public void find() throws Exception {
        int foundIndex = new FindInSortedRotatedArray().find(new int[]{4, 5, 6, 7, 0, 1, 2}, 1);
        Assert.assertEquals(5, foundIndex);
    }
}