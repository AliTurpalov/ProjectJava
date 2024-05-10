import org.junit.*;
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
        Assert.assertEquals("Min = 1", expected, actual);
        System.out.println("Min sovpalo: " + actual);
    }

    @Test
    public void testMax() {
        int expected = 4;
        int actual = StatisticsCalculator._max(testNumbers);
        Assert.assertEquals("Max = 4", expected, actual);
        System.out.println("Max sovpalo: " + actual);
    }

    @Test
    public void testSum() {
        int expected = 10;
        int actual = StatisticsCalculator._sum(testNumbers);
        Assert.assertEquals("Summ = 10", expected, actual);
        System.out.println("Summ sovpalo: " + actual);
    }


    @Test
    public void testMult() {
        long expected = 24;
        long actual = StatisticsCalculator._mult(testNumbers);
        Assert.assertEquals("Произведение всех чисел должно быть 24", expected, actual);
        System.out.println("Произведение всех чисел корректно: " + actual);
    }
}
        long expected = 24;
        long actual = StatisticsCalculator._mult(testNumbers);
        Assert.assertEquals("Ïðîèçâåäåíèå âñåõ ÷èñåë äîëæíî áûòü 24", expected, actual);
        System.out.println("Ïðîèçâåäåíèå âñåõ ÷èñåë êîððåêòíî: " + actual);
    }
}
