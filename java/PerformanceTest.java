import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PerformanceTest {

    @Test
    public void testPerformance() {
        int initialSize = 3;  // ��������� ���������� ���������
        int stepSize = 2;     // ��� ���������� ������� �������
        int numberOfArrays = 7; // ���������� ��������

        for (int i = 0; i < numberOfArrays; i++) {
            int currentSize = initialSize + i * stepSize;
            List<Integer> numbers = generateRandomNumbers(currentSize, 1, 15);
            
            long startTime, duration;
            System.out.println("������ " + (i+1) + " (" + currentSize + " ���������): " + numbers);

            // ������������ �����
            startTime = System.nanoTime();
            int sum = StatisticsCalculator._sum(numbers);
            duration = System.nanoTime() - startTime;
            System.out.println("�����: " + sum + ", ����� ����������: " + duration);

            // ������������ ������������
            startTime = System.nanoTime();
            long mult = StatisticsCalculator._mult(numbers);
            duration = System.nanoTime() - startTime;
            System.out.println("������������: " + mult + ", ����� ����������: " + duration);
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
