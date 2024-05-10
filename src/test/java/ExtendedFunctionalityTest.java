import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExtendedFunctionalityTest {

    @Test
    public void testRandomArrayOperations() {
        List<Integer> numbers = generateRandomNumbers(15, 1, 10);
        System.out.println("Massiv: " + numbers);

        System.out.println("Min: " + StatisticsCalculator._min(numbers));
        System.out.println("Max: " + StatisticsCalculator._max(numbers));
        System.out.println("Sum: " + StatisticsCalculator._sum(numbers));
        System.out.println("Proizvedenie: " + StatisticsCalculator._mult(numbers));
    }

    private List<Integer> generateRandomNumbers(int count, int min, int max) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(max - min + 1) + min);
        }
        return numbers;
    }
}
