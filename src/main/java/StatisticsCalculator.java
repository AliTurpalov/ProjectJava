import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsCalculator {

    public static List<Integer> readNumbersFromFile(String filePath) throws IOException {
        String content = Files.readString(Paths.get(filePath));
        return Arrays.stream(content.split("\\s+"))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    public static int findMin(List<Integer> numbers) {
        return numbers.stream().min(Integer::compare).orElseThrow();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElseThrow();
    }

    public static int sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static long multiplyAll(List<Integer> numbers) {
        return numbers.stream().reduce(1, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        try {
            List<Integer> numbers = readNumbersFromFile("numbers.txt");
            System.out.println("Минимальное число: " + findMin(numbers));
            System.out.println("Максимальное число: " + findMax(numbers));
            System.out.println("Сумма всех чисел: " + sumAll(numbers));
            System.out.println("Произведение всех чисел: " + multiplyAll(numbers));
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
