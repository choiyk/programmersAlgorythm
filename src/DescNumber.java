import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class DescNumber {

    public long solution(long n) {
        int size = String.valueOf(n).length();
        String[] arr = new String[size];
        for(int i=0; i<size; i++){
            arr[i] = "" + (n % 10);
            n /= 10;
        }
        String temp = Arrays.stream(arr).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
        return Long.valueOf(temp);
    }

    public long solution2(long n) {
        //제일 빠름. Stream을 쓰면 속도가 느려짐.
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String aList : list) sb.append(aList);

        return Long.parseLong(sb.reverse().toString());
    }

    public long solution3(long n) {
        return Long.parseLong(String.valueOf(n).chars().mapToObj(ch -> (char) ch)
                .sorted(Comparator.reverseOrder())
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());
    }

    public static void main(String[] args) {
        long n = 118372;
        DescNumber o = new DescNumber();
        System.out.println(o.solution(n));
    }
}
