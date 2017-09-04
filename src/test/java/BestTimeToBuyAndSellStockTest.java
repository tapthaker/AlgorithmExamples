import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tapan on 9/2/2017.
 */
public class BestTimeToBuyAndSellStockTest {

    @Test
    public void calculate() {
        int maxProfit = new BestTimeToBuyAndSellStock().calculate(new int[]{7, 1, 5, 3, 6, 4});
        Assert.assertEquals(5, maxProfit);
    }

    @Test
    public void calculate1() {
        int maxProfit = new BestTimeToBuyAndSellStock().calculate(new int[]{7, 1, 5, -10, 3, 6, 4});
        Assert.assertEquals(16, maxProfit);
    }

}