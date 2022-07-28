import java.util.Arrays;
import java.util.Comparator;

public class SortString {

    public String[] solution(String[] strings, int n) {
        Comparator<String> comparator = Comparator.comparing(String::valueOf, (word1, word2) -> {
            int result = word1.charAt(n) - word2.charAt(n);
            if(result == 0) return word1.compareTo(word2);
            return result;
        });
        Arrays.sort(strings, comparator);
        return strings;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"abce", "abcd", "cdx"};
        int n = 2;
        SortString o = new SortString();
        System.out.println(Arrays.toString(o.solution(strings, n)));
    }
}
