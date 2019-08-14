import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {

    private int[] input;
    private List<List<Integer>> expected;
    private Solution soln = new Solution3();

    public SolutionTest(int[] in, List<List<Integer>> out) {
        input = in;
        expected = out;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {new int[]{-1, 0, 1, 2, -1, -4}, Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1))},
//                {new int[]{10,-2,-12,3,-15,-12,2,-11,3,-12,9,12,0,-5,-4,-2,-7,-15,7,4,-5,-14,-15,-15,-4,
//                        10,9,-6,7,1,12,-6,14,-15,12,14,10,0,10,-10,3,4,-12,10,7,-9,-7,-15,-8,-15,-4,2,9,
//                        -4,3,-10,13,-3,-1,5,5,-4,-15,4,-11,4,-4,6,-11,-9,12,7,11,7,2,-5,13,10,-5,-10,3,
//                        7,0,-3,10,-12,2,9,-8,8,-9,13,12,13,-6,8,3,5,-9,7,12,10,-8,0,2,1,10,-7,-3,-10,-10,
//                        7,4,5,-11,-8,0,-2,-14,8,13,-8,-2,10,13}, null},
                {new int[]{0, 0, 0}, Arrays.asList(Arrays.asList(0, 0, 0))},
                {new int[]{-2, 0, 1, 1, 2}, Arrays.asList(Arrays.asList(-2, 0, 2), Arrays.asList(-2, 1, 1))},
                {new int[]{3, 0, -2, -1, 1, 2}, Arrays.asList(Arrays.asList(-2, -1, 3), Arrays.asList(-2, 0, 2), Arrays.asList(-1, 0, 1))},
                {new int[]{-1,0,1,2,-1,-4}, Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1))}
        });
    }

    @Test
    public void test3Sum() {
        assertEquals(expected, soln.threeSum(input));
    }
}