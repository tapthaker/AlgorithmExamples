import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Tapan on 9/3/2017.
 */
public class CombinationOfArrayTest {

  @Test
  public void findCombinations() {

    ArrayList<int[]> combinations = new CombinationOfArray().findCombinations(new int[][]{{1, 2, 3}, {1}, {1, 2}});
  }

}