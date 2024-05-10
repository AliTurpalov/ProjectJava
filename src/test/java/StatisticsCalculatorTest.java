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
        Assert.assertEquals("����������� �������� ������ ���� 1", expected, actual);
        System.out.println("����������� �������� ���������: " + actual);
    }

    @Test
    public void testMax() {
        int expected = 4;
        int actual = StatisticsCalculator._max(testNumbers);
        Assert.assertEquals("������������ �������� ������ ���� 4", expected, actual);
        System.out.println("������������ �������� ���������: " + actual);
    }

    @Test
    public void testSum() {
        int expected = 10;
        int actual = StatisticsCalculator._sum(testNumbers);
        Assert.assertEquals("����� ���� ����� ������ ���� 10", expected, actual);
        System.out.println("����� ���� ����� ���������: " + actual);
    }

    @Test
    public void testMult() {
        long expected = 24;
        long actual = StatisticsCalculator._mult(testNumbers);
        Assert.assertEquals("������������ ���� ����� ������ ���� 24", expected, actual);
        System.out.println("������������ ���� ����� ���������: " + actual);
    }
}
