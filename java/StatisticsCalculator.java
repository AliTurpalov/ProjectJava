import org.junit.Test;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class StatisticsCalculator {
    public static void main(String[] args) {
        try {
            List<Integer> numbers = readNumbersFromFile("numbers.txt");
            System.out.println("Ìèíèìàëüíîå: " + _min(numbers));
            System.out.println("Ìàêñèìàëüíîå: " + _max(numbers));
            System.out.println("Ñóììà: " + _sum(numbers));
            System.out.println("Ïðîèçâåäåíèå: " + _mult(numbers));
        } catch (IOException e) {
            System.out.println("Îøèáêà ïðè ÷òåíèè ôàéëà: " + e.getMessage());
        }
    }

    public static List<Integer> readNumbersFromFile(String filename) throws IOException {
        String content = Files.readString(Path.of(filename));
        String[] tokens = content.split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String token : tokens) {
                numbers.add(Integer.parseInt(token));
            }
        } catch (NumberFormatException e) {
            System.err.println("Îøèáêà â ôîðìàòå ÷èñëà: " + e.getMessage());
        }
        return numbers;
    }


    public static int _min(List<Integer> numbers) {
        return Collections.min(numbers);
    }

    public static int _max(List<Integer> numbers) {
        return Collections.max(numbers);
    }

    public static int _sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static long _mult(List<Integer> numbers) {
        return numbers.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
    }
}
