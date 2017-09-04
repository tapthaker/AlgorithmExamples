import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tapan on 9/3/2017.
 */
public class TimeCardTest {
    @Test
    public void calculate() throws Exception {
        TimeCard timeCard = new TimeCard();
        timeCard.enter("September", 1.2f, 4.5f);
        timeCard.enter("June", 3.1f, 6.7f);
        timeCard.enter("August", 8.9f, 10.3f);
        timeCard.calculate();
    }
}