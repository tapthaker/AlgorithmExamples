import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tapan on 9/3/2017.
 */
public class AlienDictionaryTest {
    @Test
    public void getCharactersSortingOrder() throws Exception {

        AlienDictionary alienDictionary = new AlienDictionary();
        char[] alphabets = alienDictionary.getCharactersSortingOrder(new String[] {"baa", "abcd", "abca", "cab", "cad"});
        assertArrayEquals(new char[]{'b', 'd', 'a', 'c'}, alphabets);
    }

}