import java.util.ArrayList;
import java.util.Arrays;

public class Divisor {

    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> divised = new ArrayList<>();
        for(int i : arr){
            if(i % divisor == 0)
                divised.add(i);
        }

        if(divised.size() == 0) return new int[]{-1};
        return divised.stream().mapToInt(i -> Integer.valueOf(i)).sorted().toArray();
    }

    public int[] solution2(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(n -> n % divisor == 0).sorted().toArray();
        if(answer.length == 0) return new int[]{-1};
        else return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 36, 1, 3};
        int divisor = 1;
        Divisor o = new Divisor();
        System.out.println(Arrays.toString(o.solution2(arr, divisor)));
    }
}
