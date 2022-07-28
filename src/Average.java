import java.util.Arrays;

public class Average {

    public double solution(int[] arr) {
        double answer = Arrays.stream(arr).average().orElse(0);
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        Average o = new Average();
        System.out.println(o.solution(arr));
    }
}
