import org.junit.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsCalculatorTest {
    private List<Integer> testNumbers;

    @Before
    public void setUp() throws IOException {
        String content = Files.readString(Path.of("numbers.txt"));
        testNumbers = Arrays.stream(content.split("\\s+"))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
    }

    @Test
    public void testMin() {
        int expected = 1;
        int actual = StatisticsCalculator._min(testNumbers);
        Assert.assertEquals("Ìèíèìàëüíîå çíà÷åíèå äîëæíî áûòü 1", expected, actual);
        System.out.println("Ìèíèìàëüíîå çíà÷åíèå êîððåêòíî: " + actual);
    }

    @Test
    public void testMax() {
        int expected = 4;
        int actual = StatisticsCalculator._max(testNumbers);
        Assert.assertEquals("Ìàêñèìàëüíîå çíà÷åíèå äîëæíî áûòü 4", expected, actual);
        System.out.println("Ìàêñèìàëüíîå çíà÷åíèå êîððåêòíî: " + actual);
    }

    @Test
    public void testSum() {
        int expected = 10;
        int actual = StatisticsCalculator._sum(testNumbers);
        Assert.assertEquals("Ñóììà âñåõ ÷èñåë äîëæíà áûòü 10", expected, actual);
        System.out.println("Ñóììà âñåõ ÷èñåë êîððåêòíà: " + actual);
    }

    @Test
    public void testMult() {
        long expected = 24;
        long actual = StatisticsCalculator._mult(testNumbers);
        Assert.assertEquals("Ïðîèçâåäåíèå âñåõ ÷èñåë äîëæíî áûòü 24", expected, actual);
        System.out.println("Ïðîèçâåäåíèå âñåõ ÷èñåë êîððåêòíî: " + actual);
    }
}
