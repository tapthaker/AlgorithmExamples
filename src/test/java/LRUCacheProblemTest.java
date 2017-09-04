import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Tapan on 9/2/2017.
 */
public class LRUCacheProblemTest {
    @Test
    public void shouldSolveLRUCache() {
        LRUCache lruCache = new LRUCache();
        lruCache.set(9,9);
        lruCache.set(8,8);
        lruCache.set(1,1);
        lruCache.get(9);
        lruCache.set(2,2);
        lruCache.set(3,3);
        lruCache.set(4,4);
        lruCache.set(5,5);
        lruCache.set(6,6);
        lruCache.set(7,7);
        lruCache.set(10,10);
        lruCache.set(6, 6);
        lruCache.get(5);
        lruCache.get(3);
        lruCache.get(2);
        lruCache.set(11,11);
        Assert.assertEquals(lruCache.getStringFromHEAD(), "11:11=>2:2=>3:3=>5:5=>6:6=>10:10=>7:7=>4:4=>9:9=>1:1=>");
        Assert.assertEquals(lruCache.getStringFromTAIL(), "11:11=>2:2=>3:3=>5:5=>6:6=>10:10=>7:7=>4:4=>9:9=>1:1=>");
    }
}