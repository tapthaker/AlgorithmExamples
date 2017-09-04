import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tapan on 9/2/2017.
 */
public class FindNumberOfIslandsTest {
    @Test
    public void find() throws Exception {
        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        int numberOfIslands = new FindNumberOfIslands().find(matrix);
        Assert.assertEquals(4, numberOfIslands);
    }

}