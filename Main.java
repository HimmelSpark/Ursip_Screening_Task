import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String s1 = generateNum(Arrays.asList(7,1,2,3,4,5,6));
        System.out.println(s1); //008
        String s2 = generateNum(Arrays.asList(1,3,4,2));
        System.out.println(s2); //005
        String s3 = generateNum(Arrays.asList(3,1,2,7,5));
        System.out.println(s3); //004
    }

    private static String generateNum(List<Integer> numbers) {
        TreeSet<Integer> treeSet = new TreeSet<>(numbers);
        return treeSet.stream()
                .reduce((a, b) -> Math.abs(a - b) > 1 ? Math.min(a, b) : Math.max(a, b))
                .map(i -> i + 1)
                .map(Main::get3DigitString)
                .orElseGet(() -> get3DigitString(treeSet.last() + 1));
    }

    private static String get3DigitString(Integer number) {
        return String.format("%03d", number);
    }
}
