import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class DescString {

    public String solution(String s) {
        Comparator<Integer> comparator = Comparator.comparing(Integer::valueOf, (i, j) -> {
            return j - i;
        });
        return s.chars().boxed().sorted(Comparator.reverseOrder())
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public static void main(String[] args) {
        String s = "Zbcdefg";
        DescString o = new DescString();
        System.out.println(o.solution(s));
    }
}
