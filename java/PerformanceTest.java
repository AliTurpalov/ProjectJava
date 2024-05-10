import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PerformanceTest {

    @Test
    public void testPerformance() {
        int initialSize = 3;  // Íà÷àëüíîå êîëè÷åñòâî ýëåìåíòîâ
        int stepSize = 2;     // Øàã óâåëè÷åíèÿ ðàçìåðà ìàññèâà
        int numberOfArrays = 7; // Êîëè÷åñòâî ìàññèâîâ

        for (int i = 0; i < numberOfArrays; i++) {
            int currentSize = initialSize + i * stepSize;
            List<Integer> numbers = generateRandomNumbers(currentSize, 1, 15);
            
            long startTime, duration;
            System.out.println("Ìàññèâ " + (i+1) + " (" + currentSize + " ýëåìåíòîâ): " + numbers);

            // Òåñòèðîâàíèå ñóììû
            startTime = System.nanoTime();
            int sum = StatisticsCalculator._sum(numbers);
            duration = System.nanoTime() - startTime;
            System.out.println("Ñóììà: " + sum + ", Âðåìÿ âûïîëíåíèÿ: " + duration);

            // Òåñòèðîâàíèå ïðîèçâåäåíèÿ
            startTime = System.nanoTime();
            long mult = StatisticsCalculator._mult(numbers);
            duration = System.nanoTime() - startTime;
            System.out.println("Ïðîèçâåäåíèå: " + mult + ", Âðåìÿ âûïîëíåíèÿ: " + duration);
        }
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
