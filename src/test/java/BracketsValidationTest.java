import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tapan on 9/3/2017.
 */
public class BracketsValidationTest {
    @Test
    public void validate1() throws Exception {
        boolean isValid = new BracketsValidation().validate("{(abc)22}[14(xyz)2]");
        Assert.assertTrue(isValid);
    }

    @Test
    public void validate2() throws Exception {
        boolean isValid = new BracketsValidation().validate("[ { ] }");
        Assert.assertFalse(isValid);
    }

    @Test
    public void validate3() throws Exception {
        boolean isValid = new BracketsValidation().validate("{ (x) } [");
        Assert.assertFalse(isValid);
    }

}