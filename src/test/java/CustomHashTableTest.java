import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tapan on 9/3/2017.
 */
public class CustomHashTableTest {
    @Test
    public void hashing() throws Exception {
        CustomHashTable<String, String> hashTable = new CustomHashTable<String, String>();
        hashTable.set("100", "hundred");
        hashTable.set("500","fivehundred");
        hashTable.set("4534","fortyfivehundredandthirtyfour");
        hashTable.set("500","panchsoo");

        Assert.assertEquals("hundred", hashTable.get("100"));
        Assert.assertEquals("panchsoo", hashTable.get("500"));
        Assert.assertNull(hashTable.get("433234"));
    }
}