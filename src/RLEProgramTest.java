import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RLEProgramTest {
    @Test
    public void countRunsTest() {
        byte[] flatData = {15,15,1,1,1,6,2,2};
        int groups = 4; // expected result
        assertEquals(groups, RleProgram.countRuns(flatData));
    }

    @Test
    public void encodeRleTest() {
        byte[] flatData = {15,15,1,1,1,6,2,2}; // input
        byte[] rleData = {2,15,3,1,1,6,2,2}; // output/expected result

        byte[] actualResult = RleProgram.encodeRle(flatData);

        assertArrayEquals(rleData, actualResult);
    }
}
